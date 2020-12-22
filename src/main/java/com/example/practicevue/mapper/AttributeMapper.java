package com.example.practicevue.mapper;

import com.example.practicevue.entity.Attribute;
import com.example.practicevue.model.AttributeDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttributeMapper extends Mapper<Attribute> {

    int batchInsert(List<AttributeDTO> attributeDTOList);
}