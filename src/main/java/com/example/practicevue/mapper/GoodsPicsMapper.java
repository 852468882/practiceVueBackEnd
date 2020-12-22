package com.example.practicevue.mapper;

import com.example.practicevue.entity.GoodsPics;
import com.example.practicevue.model.GoodsPicsDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsPicsMapper extends Mapper<GoodsPics> {

    /**
     * 批量插入
     */
    int batchInsert(List<GoodsPicsDTO> picsList);

    /**
     * 批量修改
     */
    void batchUpdate(List<GoodsPics> picsList);
}