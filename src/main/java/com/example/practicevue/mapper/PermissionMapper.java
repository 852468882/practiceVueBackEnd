package com.example.practicevue.mapper;

import com.example.practicevue.entity.Permission;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.PermissionListDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<MenusDTO> getLeftMenus();

    List<PermissionListDTO> allPermissionList();

    /**
     * 获取顶级菜单
     * @param permissionIdList 权限ID列表
     */
    List<MenusDTO> superMenuList(List<Integer> permissionIdList);

    /**
     * 查询角色下的所有菜单
     * @param permissionIdList 权限ID列表
     */
    List<MenusDTO> allMenuList(List<Integer> permissionIdList);

}