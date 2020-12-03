package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Manager;
import com.example.practicevue.model.ManagerDTO;
import com.example.practicevue.service.ManagerService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * @author zcy
 * @date 2020/11/9
 */
@RestController
@Slf4j
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 登录
     *
     * @param managerDTO 用户登录信息
     * @return 用户信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public APIResponse<Manager> login(@RequestBody ManagerDTO managerDTO) {
        Manager login = managerService.login(managerDTO);
        if (login == null) {
            return APIResponse.fail("用户名密码不匹配");
        } else {
            String token = UUID.randomUUID().toString().replace("-", "");
            return APIResponse.success(token, login);
        }
    }

    /**
     * 获取用户列表
     *
     * @param managerDTO 请求参数
     * @return 用户列表信息
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public APIResponse<PageInfo<ManagerDTO>> userList(ManagerDTO managerDTO) {
        PageInfo<ManagerDTO> userList = managerService.getUserList(managerDTO);
        return APIResponse.success(userList);
    }

    /**
     * 根据ID获取用户信息详情
     *
     * @param id ID
     * @return 用户信息详情
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public APIResponse<ManagerDTO> user(@PathVariable Integer id) {
        ManagerDTO managerDTO = managerService.getUserById(id);
        return APIResponse.success(managerDTO);
    }

    /**
     * 根据ID修改用户状态
     *
     * @param id     ID
     * @param status 用户状态
     * @return 修改信息
     */
    @RequestMapping(value = "/users/{id}/state/{status}", method = RequestMethod.PUT)
    public APIResponse<ManagerDTO> updateUserState(@PathVariable Integer id, @PathVariable Boolean status) {
        return managerService.updateUserState(id, status);
    }

    /**
     * 创建用户
     *
     * @param manager 用户信息
     * @return 创建信息
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public APIResponse<ManagerDTO> createUser(@RequestBody Manager manager) {
        return managerService.createUser(manager);
    }

    /**
     * 编辑用户
     *
     * @param managerDTO 用户信息
     * @return 编辑信息
     */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public APIResponse<ManagerDTO> editUser(@RequestBody ManagerDTO managerDTO) {
        return managerService.editUser(managerDTO);
    }

    /**
     * 根据用户ID删除用户
     *
     * @param id ID
     * @return 删除信息
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public APIResponse<ManagerDTO> deleteUser(@PathVariable Integer id) {
        return managerService.deleteUser(id);
    }

    /**
     * 设置用户新角色
     *
     * @param id     用户ID
     * @param roleId 角色ID
     * @return 用户信息
     */
    @RequestMapping(value = "/users/{id}/role", method = RequestMethod.PUT)
    public APIResponse<ManagerDTO> setUserRole(@PathVariable Integer id, @RequestBody Map<String, Integer> roleId) {
        Integer rid = roleId.get("rid");
        return managerService.setUserRole(id, rid);
    }
}
