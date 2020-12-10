package com.example.practicevue;

import com.alibaba.fastjson.JSONObject;
import com.example.practicevue.entity.Permission;
import com.example.practicevue.entity.Role;
import com.example.practicevue.mapper.*;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.PermissionListDTO;
import com.example.practicevue.model.RolePermissionDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcy
 * @date 2020/10/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringTest {

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private ManagerMapper managerMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private AttributeMapper attributeMapper;
    @Resource
    private CategoryMapper categoryMapper;

    @Test
    public void t1(){
        List<MenusDTO> leftMenus = permissionMapper.getLeftMenus();
        System.out.println(JSONObject.toJSONString(leftMenus));
    }

    @Test
    public void t2(){
        List<PermissionListDTO> list = permissionMapper.allPermissionList();
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void t3(){
        List<RolePermissionDTO> rolePermissionDTOList = new ArrayList<>();
        List<Role> roles = roleMapper.selectAll();
        roles.forEach(role -> {
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
            for (MenusDTO menusDTO : superMenuList) {
                List<MenusDTO> childMenuTree = childMenuTree(menusDTO.getId(), allMenuList);
                menusDTO.setChildren(childMenuTree);
            }

            RolePermissionDTO rolePermissionDTO = new RolePermissionDTO();
            rolePermissionDTO.setId(role.getId());
            rolePermissionDTO.setRoleName(role.getRoleName());
            rolePermissionDTO.setRoleDesc(role.getRoleDesc());
            rolePermissionDTO.setChildren(superMenuList);

            System.out.println(JSONObject.toJSONString(rolePermissionDTO));

            rolePermissionDTOList.add(rolePermissionDTO);
        });

    }

    @Test
    public void t4(){
        List<MenusDTO> menusDTOList = new ArrayList<>();

        List<String> strings = getdeleteList("101");
        System.out.println(strings);
    }

    @Test
    public void updatesp_goods_attr(){
    }


    /**
     * 递归获取子菜单树
     */
    private List<MenusDTO> childMenuTree(Integer parentId, List<MenusDTO> allMenuList){
        List<MenusDTO> menuTree = new ArrayList<>();
        for (MenusDTO menusDTO : allMenuList) {
            if (menusDTO.getPid() != 0 && menusDTO.getPid().equals(parentId)){
                MenusDTO menus = new MenusDTO();
                menus.setId(menusDTO.getId());
                menus.setAuthName(menusDTO.getAuthName());
                menus.setChildren(menusDTO.getChildren());
                menuTree.add(menus);
            }
        }

        for (MenusDTO menusDTO : menuTree) {
            List<MenusDTO> childMenuList = childMenuTree(menusDTO.getId(), allMenuList);
            if (childMenuList.size() > 0) {
                menusDTO.setChildren(childMenuList);
            }
        }

        return menuTree;
    }

    /**
     * 递归获取删除权限列表
     */
    private List<String> getdeleteList(String rightId){
        List<String> deleteList = new ArrayList<>();
        deleteList.add(rightId);
        Example example = new Example(Permission.class);
        example.createCriteria().andEqualTo("pid", rightId);
        List<Permission> permissions = permissionMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(permissions)){
            for (Permission permission : permissions) {
                deleteList.addAll(getdeleteList(String.valueOf(permission.getId())));
            }
        }
        return deleteList;
    }
}
