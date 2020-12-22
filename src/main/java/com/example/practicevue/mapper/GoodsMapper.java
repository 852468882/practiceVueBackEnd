package com.example.practicevue.mapper;

import com.example.practicevue.entity.Goods;
import com.example.practicevue.model.GoodsDTO;
import tk.mybatis.mapper.common.Mapper;

public interface GoodsMapper extends Mapper<Goods> {

    GoodsDTO selectGoodsById(Integer id);
}