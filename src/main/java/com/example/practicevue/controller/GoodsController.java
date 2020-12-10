package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Goods;
import com.example.practicevue.model.GoodsDTO;
import com.example.practicevue.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zcy
 * @date 2020/12/4
 */
@RestController
@RequestMapping(path = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public APIResponse<PageInfo<Goods>> goodsList(String query, GoodsDTO goodsDTO) {
        return APIResponse.success(goodsService.goodsList(query, goodsDTO));
    }

    @RequestMapping(method = RequestMethod.POST)
    public APIResponse<GoodsDTO> createGoods(GoodsDTO goodsDTO){
        return goodsService.createGoods(goodsDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public APIResponse<GoodsDTO> selectGoodsById(@PathVariable Integer id){
        return goodsService.selectGoodsById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public APIResponse<GoodsDTO> editGoods(@PathVariable Integer id, @RequestBody GoodsDTO goodsDTO){
        return goodsService.editGoods(id, goodsDTO);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public APIResponse<GoodsDTO> deleteGoods(@PathVariable Integer id){
        return goodsService.deleteGoods(id);
    }
}
