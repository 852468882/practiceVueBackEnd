package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Role;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.RoleDTO;
import com.example.practicevue.model.RolePermissionDTO;
import com.example.practicevue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zcy
 * @date 2020/11/13
 */
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public APIResponse<List<Role>> roleList(){
        return APIResponse.success(roleService.getRoleList());
    }

    /**
     * 权限角色列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public APIResponse<List<RolePermissionDTO>> rolePermissions() {
        List<RolePermissionDTO> allRoles = roleService.getRolePermissions();
        return APIResponse.success(allRoles);
    }

    /**
     * 添加角色
     */
    @RequestMapping(method = RequestMethod.POST)
    public APIResponse<RoleDTO> createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    /**
     * 根据 ID 查询角色
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public APIResponse<RoleDTO> getRoleById(@PathVariable Integer id) {
        return roleService.getRoleById(id);
    }

    /**
     * 编辑提交角色
     */
    @RequestMapping(method = RequestMethod.PUT)
    public APIResponse<RoleDTO> editRole(@RequestBody Role role) {
        return roleService.editRole(role);
    }

    /**
     * 删除角色
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public APIResponse<RoleDTO> deleteRole(@PathVariable Integer id) {
        return roleService.deleteRole(id);
    }

    /**
     * 角色授权
     */
    @RequestMapping(value = "/{id}/rights", method = RequestMethod.POST)
    public APIResponse<RoleDTO> authorizeRole(@PathVariable Integer id, @RequestBody Map<String, String> psIds) {
        String rids = psIds.get("rids");
        return roleService.authorizeRole(id, rids);
    }

    /**
     * 删除角色指定权限
     */
    @RequestMapping(value = "/{id}/rights/{rightId}", method = RequestMethod.DELETE)
    public APIResponse<List<MenusDTO>> deletePermission(@PathVariable Integer id, @PathVariable String rightId) {
        return roleService.deletePermission(id, rightId);
    }

}
