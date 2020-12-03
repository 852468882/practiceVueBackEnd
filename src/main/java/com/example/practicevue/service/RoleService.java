package com.example.practicevue.service;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Role;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.RoleDTO;
import com.example.practicevue.model.RolePermissionDTO;

import java.util.List;

/**
 * @author zcy
 * @date 2020/11/13
 */
public interface RoleService {

    List<Role> getRoleList();

    List<RolePermissionDTO> getRolePermissions();

    APIResponse<RoleDTO> createRole(Role role);

    APIResponse<RoleDTO> getRoleById(Integer id);

    APIResponse<RoleDTO> editRole(Role role);

    APIResponse<RoleDTO> deleteRole(Integer id);

    APIResponse<RoleDTO> authorizeRole(Integer id, String rids);

    APIResponse<List<MenusDTO>> deletePermission(Integer id, String rightId);
}
