package com.example.practicevue.service.impl;

import com.example.practicevue.mapper.PermissionMapper;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.PermissionListDTO;
import com.example.practicevue.service.PermissionService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcy
 * @date 2020/11/11
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<MenusDTO> leftMenu() {
        return permissionMapper.getLeftMenus();
    }

    @Override
    public List<PermissionListDTO> allPermissionList() {
        return permissionMapper.allPermissionList();
    }

    @Override
    public List<MenusDTO> allPermissionTree() {
        // 所有顶级权限
        List<MenusDTO> superMenuList = permissionMapper.superMenuList(null);
        // 所有权限
        List<MenusDTO> allMenuList = permissionMapper.allMenuList(null);
        // 获取菜单树
        superMenuList.forEach(menusDTO -> {
            menusDTO.setChildren(childMenuTree(menusDTO.getId(), allMenuList));
        });
        return superMenuList;
    }

    /**
     * 递归获取子菜单树
     */
    private List<MenusDTO> childMenuTree(Integer parentId, List<MenusDTO> allMenuList){
        List<MenusDTO> menuTree = new ArrayList<>();
        for (MenusDTO menusDTO : allMenuList) {
            if (menusDTO.getPid() != 0 && menusDTO.getPid().equals(parentId)){
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
}
