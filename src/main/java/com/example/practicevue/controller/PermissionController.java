package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.model.MenusDTO;
import com.example.practicevue.model.PermissionListDTO;
import com.example.practicevue.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zcy
 * @date 2020/11/11
 */
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping(value = "/menus")
    public APIResponse menus(){
        return APIResponse.success("获取菜单列表成功",permissionService.leftMenu());
    }

    @GetMapping(path = "/rights/{type}")
    public APIResponse<Object> allPermission(@PathVariable String type){
        APIResponse<Object> apiResponse;
        if ("list".equals(type)){
            List<PermissionListDTO> allPermissionList = permissionService.allPermissionList();
            apiResponse = APIResponse.success(allPermissionList);
        } else if ("tree".equals(type)){
            List<MenusDTO> allPermissionTree = permissionService.allPermissionTree();
            apiResponse = APIResponse.success(allPermissionTree);
        } else {
            apiResponse = APIResponse.fail();
        }
        return apiResponse;
    }
}