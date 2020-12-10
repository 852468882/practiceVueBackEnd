package com.example.practicevue.mapper;

import com.example.practicevue.entity.GoodsPics;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsPicsMapper extends Mapper<GoodsPics> {

    /**
     * 批量插入
     */
    int batchInsert(List<GoodsPics> picsList);

    /**
     * 批量修改
     */
    void batchUpdate(List<GoodsPics> picsList);
}