package com.example.practicevue.service.impl;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Goods;
import com.example.practicevue.entity.GoodsPics;
import com.example.practicevue.mapper.GoodsAttrMapper;
import com.example.practicevue.mapper.GoodsMapper;
import com.example.practicevue.mapper.GoodsPicsMapper;
import com.example.practicevue.model.GoodsDTO;
import com.example.practicevue.model.GoodsPicsDTO;
import com.example.practicevue.service.GoodsService;
import com.example.practicevue.utils.PageHelperUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private GoodsPicsMapper goodsPicsMapper;
    @Resource
    private GoodsAttrMapper goodsAttrMapper;

    @Override
    public PageInfo<Goods> goodsList(String query, GoodsDTO goodsDTO) {
        Example example = new Example(Goods.class);
        example.selectProperties("id", "name", "price", "number", "weight", "state", "addTime", "updTime", "hotNumber", "isPromote");
        example.createCriteria().andLike("name", "%" + query + "%");
        return PageHelperUtil.page(goodsDTO.getPageNum(), goodsDTO.getPageSize(), () -> goodsMapper.selectByExample(example));
    }

    @Override
    @Transactional
    public APIResponse<GoodsDTO> createGoods(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        goods.setName(goodsDTO.getName());
        String[] catIds = goodsDTO.getCategory().split(",");
        goods.setCatId(Integer.valueOf(catIds[2]));
        goods.setCatThreeId(Integer.valueOf(catIds[2]));
        goods.setCatTwoId(Integer.valueOf(catIds[1]));
        goods.setCatOneId(Integer.valueOf(catIds[0]));
        goods.setPrice(goodsDTO.getPrice());
        goods.setNumber(goodsDTO.getNumber());
        goods.setWeight(goodsDTO.getWeight());
        goods.setIntroduce(goodsDTO.getIntroduce());

        goods.setAddTime(new Date());
        goods.setUpdTime(new Date());
        goodsMapper.insertSelective(goods);

        if (CollectionUtils.isNotEmpty(goodsDTO.getPics())){
            List<GoodsPics> pics = new ArrayList<>();
            for (GoodsPicsDTO pic : goodsDTO.getPics()) {
                GoodsPics goodsPics = new GoodsPics();
                goodsPics.setGoodsId(goods.getId());
                // TODO: 2020/12/7 为图片路径赋值
                pics.add(goodsPics);
            }
            goodsPicsMapper.batchInsert(pics);
        }
        // TODO: 2020/12/8 添加属性
        return APIResponse.created();
    }

    @Override
    public APIResponse<GoodsDTO> selectGoodsById(Integer id) {
        return APIResponse.success(goodsMapper.selectGoodsById(id));
    }

    @Override
    @Transactional
    public APIResponse<GoodsDTO> editGoods(Integer id, GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName(goodsDTO.getName());
        goods.setPrice(goodsDTO.getPrice());
        goods.setNumber(goodsDTO.getNumber());
        goods.setWeight(goodsDTO.getWeight());
        goods.setIntroduce(goodsDTO.getIntroduce());
        goodsMapper.updateByPrimaryKeySelective(goods);

        return APIResponse.updated();
    }

    @Override
    public APIResponse<GoodsDTO> deleteGoods(Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setIsDel("1");
        goodsMapper.updateByPrimaryKeySelective(goods);
        return APIResponse.deleted();
    }
}
