package com.example.practicevue.service;

import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.PermissionListDTO;

import java.util.List;

/**
 * @author zcy
 * @date 2020/11/11
 */
public interface PermissionService {
    List<MenusDTO> leftMenu();

    List<PermissionListDTO> allPermissionList();

    List<MenusDTO> allPermissionTree();
}
