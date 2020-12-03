package com.example.practicevue.mapper;

import com.example.practicevue.entity.Manager;
import com.example.practicevue.model.ManagerDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ManagerMapper extends Mapper<Manager> {
    List<ManagerDTO> getUserList(ManagerDTO managerDTO);

    ManagerDTO getUserById(Integer id);
}