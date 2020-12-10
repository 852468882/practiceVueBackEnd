package com.example.practicevue.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Role;
import com.example.practicevue.mapper.PermissionMapper;
import com.example.practicevue.mapper.RoleMapper;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.RoleDTO;
import com.example.practicevue.model.RolePermissionDTO;
import com.example.practicevue.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcy
 * @date 2020/11/13
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Role> getRoleList() {
        Example example = new Example(Role.class);
        example.selectProperties("id","roleName");
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<RolePermissionDTO> getRolePermissions() {
        List<RolePermissionDTO> rolePermissionDTOList = new ArrayList<>();
        List<Role> roles = roleMapper.selectAll();
        roles.forEach(role -> {
            RolePermissionDTO rolePermissionDTO = getRolePermission(role);
            rolePermissionDTOList.add(rolePermissionDTO);
        });
        return rolePermissionDTOList;
    }

    @Override
    public APIResponse<RoleDTO> createRole(Role role) {
        APIResponse<RoleDTO> apiResponse = validateCreateRole(role);
        if (validateCreateRole(role).getStatus() == 200) {
            roleMapper.insertSelective(role);
            RoleDTO dto = new RoleDTO();
            dto.setId(role.getId());
            dto.setRoleName(role.getRoleName());
            dto.setRoleDesc(role.getRoleDesc());
            apiResponse = APIResponse.created();
        }
        return apiResponse;
    }

    @Override
    public APIResponse<RoleDTO> getRoleById(Integer id) {
        APIResponse<RoleDTO> apiResponse;
        Role role = roleMapper.selectByPrimaryKey(id);
        if (role != null) {
            RoleDTO dto = new RoleDTO();
            dto.setId(role.getId());
            dto.setRoleName(role.getRoleName());
            dto.setRoleDesc(role.getRoleDesc());
            apiResponse = APIResponse.success(dto);
        } else {
            apiResponse = APIResponse.fail("查询失败，找不到数据");
        }
        return apiResponse;
    }

    @Override
    public APIResponse<RoleDTO> editRole(Role role) {
        APIResponse<RoleDTO> apiResponse = validateEditRole(role);
        if (apiResponse.getStatus() == 200) {
            int i = roleMapper.updateByPrimaryKeySelective(role);
            if (i > 0) {
                RoleDTO dto = new RoleDTO();
                dto.setId(role.getId());
                dto.setRoleName(role.getRoleName());
                dto.setRoleDesc(role.getRoleDesc());
                apiResponse = APIResponse.success("修改成功", dto);
            } else {
                apiResponse = APIResponse.fail("修改失败");
            }
        }
        return apiResponse;
    }

    @Override
    public APIResponse<RoleDTO> deleteRole(Integer id) {
        APIResponse<RoleDTO> apiResponse;
        int i = roleMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            apiResponse = APIResponse.success("删除成功");
        } else {
            apiResponse = APIResponse.fail("删除失败");
        }
        return apiResponse;
    }

    @Override
    public APIResponse<RoleDTO> authorizeRole(Integer id, String rids) {
        APIResponse<RoleDTO> apiResponse;
        Role role = new Role();
        role.setId(id);
        role.setPsIds(rids);
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if (i > 0) {
            apiResponse = APIResponse.success("更新成功");
        } else {
            apiResponse = APIResponse.fail("更新失败");
        }
        return apiResponse;
    }

    @Override
    public APIResponse<List<MenusDTO>> deletePermission(Integer id, String rightId) {
        Role role = roleMapper.selectByPrimaryKey(id);
        // 当前角色所有的权限id
        List<String> psIdList = Arrays.asList(role.getPsIds().split(","));
        log.info("所有权限：" + JSONArray.toJSONString(psIdList));
        // 获取要删除的权限列表
        List<Integer> permissionIds = new ArrayList<>();
        for (String permissionId : psIdList) {
            permissionIds.add(Integer.valueOf(permissionId));
        }
        List<MenusDTO> menusDTOList = permissionMapper.allMenuList(permissionIds);

        List<String> deleteList = getDeleteList(rightId, menusDTOList);
        log.info("要删除的权限：" + JSONArray.toJSONString(deleteList));
        // 新的权限id列表
        List<String> newPsIdList = (List<String>) CollectionUtils.subtract(psIdList, deleteList);
        StringBuilder stringBuilder = new StringBuilder();
        newPsIdList.forEach(psId -> stringBuilder.append(psId).append(","));
        role.setPsIds(stringBuilder.substring(0, stringBuilder.length() > 0 ? stringBuilder.length() - 1 : stringBuilder.length()));
        log.info("删除后的权限：" + role.getPsIds());
        roleMapper.updateByPrimaryKeySelective(role);
        return APIResponse.success(getRolePermission(role).getChildren());
    }

    /**
     * 获取角色对应的权限
     */
    private RolePermissionDTO getRolePermission(Role role) {
        RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
        rolePermissionDTO.setId(role.getId());
        rolePermissionDTO.setRoleName(role.getRoleName());
        rolePermissionDTO.setRoleDesc(role.getRoleDesc());
        if (StringUtils.isBlank(role.getPsIds())) {
            return rolePermissionDTO;
        }
        // 拿到每个角色对应的权限ID列表
        List<Integer> permissionIds = new ArrayList<>();
        String[] ids = role.getPsIds().split(",");
        for (String id : ids) {
            permissionIds.add(Integer.valueOf(id));
        }
        //根据权限ID列表查询最外级权限
        List<MenusDTO> superMenuList = permissionMapper.superMenuList(permissionIds);
        //根据权限ID列表查询所有权限
        List<MenusDTO> allMenuList = permissionMapper.allMenuList(permissionIds);
        //获取菜单树
        superMenuList.forEach(menusDTO -> {
            menusDTO.setChildren(childMenuTree(menusDTO.getId(), allMenuList));
        });

        rolePermissionDTO.setChildren(superMenuList);
        return rolePermissionDTO;
    }

    /**
     * 递归获取子菜单树
     */
    private List<MenusDTO> childMenuTree(Integer id, List<MenusDTO> allMenuList) {
        List<MenusDTO> menuTree = new ArrayList<>();
        for (MenusDTO menusDTO : allMenuList) {
            if (menusDTO.getPid() != 0 && menusDTO.getPid().equals(id)) {
                menuTree.add(menusDTO);
            }
        }

        for (MenusDTO menusDTO : menuTree) {
            List<MenusDTO> childMenuList = childMenuTree(menusDTO.getId(), allMenuList);
            if (CollectionUtils.isNotEmpty(childMenuList)) {
                menusDTO.setChildren(childMenuList);
            }
        }

        return menuTree;
    }

    /**
     * 递归获取删除权限列表
     */
    private List<String> getDeleteList(String pid, List<MenusDTO> menusDTOList) {
        List<String> deleteList = new ArrayList<>();
        deleteList.add(pid);
        for (MenusDTO menusDTO : menusDTOList) {
            if (pid.equals(menusDTO.getPid() + "")) {
                deleteList.addAll(getDeleteList(menusDTO.getId() + "", menusDTOList));
            }
        }
        return deleteList;
    }

    private APIResponse<RoleDTO> validateCreateRole(Role role) {
        StringBuilder errorMessage = new StringBuilder();
        if (role.getRoleName() == null || "".equals(role.getRoleName())) {
            errorMessage.append("角色名称不能为空;");
        }
        if (StringUtils.isNotBlank(errorMessage)) {
            return APIResponse.fail(errorMessage.toString());
        } else {
            return APIResponse.success("验证通过");
        }
    }

    private APIResponse<RoleDTO> validateEditRole(Role role) {
        StringBuilder errorMessage = new StringBuilder();
        if (role.getId() == null || role.getId() == 0) {
            errorMessage.append("id不能为0或null;");
        }
        if (StringUtils.isBlank(role.getRoleName())) {
            errorMessage.append("角色名称不能为空;");
        }
        if (StringUtils.isNotBlank(errorMessage)) {
            return APIResponse.fail(errorMessage.toString());
        } else {
            return APIResponse.success("验证通过");
        }
    }
}
