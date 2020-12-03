package com.example.practicevue.service;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Manager;
import com.example.practicevue.model.ManagerDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author zcy
 * @date 2020/11/9
 */
public interface ManagerService {
    Manager login(ManagerDTO managerDTO);

    PageInfo<ManagerDTO> getUserList(ManagerDTO managerDTO);

    ManagerDTO getUserById(Integer id);

    APIResponse<ManagerDTO> updateUserState(Integer id, Boolean status);

    APIResponse<ManagerDTO> createUser(Manager manager);

    APIResponse<ManagerDTO> editUser(ManagerDTO managerDTO);

    APIResponse<ManagerDTO> deleteUser(Integer id);

    APIResponse<ManagerDTO> setUserRole(Integer id, Integer rid);
}
