package com.example.practicevue.service;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Goods;
import com.example.practicevue.model.GoodsDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author zcy
 * @date 2020/12/4
 */
public interface GoodsService {

    /**
     * 商品列表数据
     * @param goodsDTO 查询参数
     * @return 商品列表数据
     */
    PageInfo<Goods> goodsList(String query, GoodsDTO goodsDTO);

    /**
     * 添加商品
     * @param goodsDTO 商品信息
     * @return 商品信息
     */
    APIResponse<GoodsDTO> createGoods(GoodsDTO goodsDTO);

    /**
     * 根据 ID 查询商品
     * @param id id
     * @return 商品信息
     */
    APIResponse<GoodsDTO> selectGoodsById(Integer id);

    /**
     * 编辑提交商品
     * @param id id
     * @return 商品信息
     */
    APIResponse<GoodsDTO> editGoods(Integer id, GoodsDTO goodsDTO);

    /**
     * 删除商品
     * @param id id
     * @return APIResponse
     */
    APIResponse<GoodsDTO> deleteGoods(Integer id);
}
