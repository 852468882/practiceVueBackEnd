package com.example.practicevue.service.impl;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Manager;
import com.example.practicevue.mapper.ManagerMapper;
import com.example.practicevue.model.ManagerDTO;
import com.example.practicevue.service.ManagerService;
import com.example.practicevue.utils.PageHelperUtil;
import com.example.practicevue.utils.TransformDtoUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zcy
 * @date 2020/11/9
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Manager login(ManagerDTO managerDTO) {
        return managerMapper.selectOne(TransformDtoUtil.transform(managerDTO, Manager.class));
    }

    @Override
    public PageInfo<ManagerDTO> getUserList(ManagerDTO managerDTO) {
        return PageHelperUtil.page(managerDTO.getPageNum(), managerDTO.getPageSize(), () -> {
            List<ManagerDTO> userList = managerMapper.getUserList(managerDTO);
            userList.parallelStream().forEach(user -> {
                user.setStatus(user.getState() == 1);
            });
            return userList;
        });
    }

    @Override
    public ManagerDTO getUserById(Integer id) {
        return managerMapper.getUserById(id);
    }

    @Override
    public APIResponse<ManagerDTO> updateUserState(Integer id, Boolean status) {
        APIResponse<ManagerDTO> apiResponse;
        Manager manager = new Manager();
        manager.setId(id);
        manager.setState(status ? 1 : 0);
        int updateRow = managerMapper.updateByPrimaryKeySelective(manager);
        if (updateRow < 1) {
            apiResponse = APIResponse.fail();
        } else {
            apiResponse = APIResponse.updated();
        }
        return apiResponse;
    }

    @Override
    public APIResponse<ManagerDTO> createUser(Manager manager) {
        APIResponse<ManagerDTO> apiResponse;
        int rows = managerMapper.insertSelective(manager);
        if (rows != 1) {
            apiResponse = APIResponse.fail();
        } else {
            apiResponse = APIResponse.created();
        }
        return apiResponse;
    }

    @Override
    public APIResponse<ManagerDTO> editUser(ManagerDTO managerDTO) {
        APIResponse<ManagerDTO> apiResponse;
        Manager manager = TransformDtoUtil.transform(managerDTO, Manager.class);
        if (managerMapper.updateByPrimaryKeySelective(manager) == 0) {
            apiResponse = APIResponse.fail();
        } else {
            apiResponse = APIResponse.updated();
        }
        return apiResponse;
    }

    @Override
    public APIResponse<ManagerDTO> deleteUser(Integer id) {
        APIResponse<ManagerDTO> apiResponse;
        if (managerMapper.deleteByPrimaryKey(id) == 0) {
            apiResponse = APIResponse.fail();
        } else {
            apiResponse = APIResponse.ok();
        }
        return apiResponse;
    }

    @Override
    public APIResponse<ManagerDTO> setUserRole(Integer id, Integer rid) {
        APIResponse<ManagerDTO> apiResponse;
        Manager manager = new Manager();
        manager.setId(id);
        manager.setRoleId(rid);
        if (managerMapper.updateByPrimaryKeySelective(manager) > 0) {
            apiResponse = APIResponse.updated();
        } else {
            apiResponse = APIResponse.fail();
        }
        return apiResponse;
    }
}
