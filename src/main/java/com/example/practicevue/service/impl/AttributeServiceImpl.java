package com.example.practicevue.service.impl;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.GoodsAttr;
import com.example.practicevue.mapper.GoodsAttrMapper;
import com.example.practicevue.model.GoodsAttrDTO;
import com.example.practicevue.service.AttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Resource
    private GoodsAttrMapper goodsAttrMapper;

    /**
     * 参数列表
     *
     * @param id  分类 ID 不能为空，携带在url中
     * @param sel [only,many] 不能为空,通过 only 或 many 来获取分类静态参数还是动态参数
     * @return 参数列表
     */
    @Override
    public APIResponse<List<GoodsAttr>> attributesList(Integer id, String sel) {
        GoodsAttr goodsAttr = new GoodsAttr();
        goodsAttr.setCatId(id);
        goodsAttr.setSel(sel);
        List<GoodsAttr> goodsAttrList = goodsAttrMapper.select(goodsAttr);
        return APIResponse.success(goodsAttrList);
    }

    /**
     * 添加动态参数或者静态属性
     *
     * @param id           分类 ID 不能为空，携带在url中
     * @param goodsAttrDTO 添加信息
     * @return 添加信息
     */
    @Override
    public APIResponse<GoodsAttr> createAttribute(Integer id, GoodsAttrDTO goodsAttrDTO) {
        GoodsAttr goodsAttr = new GoodsAttr();
        goodsAttr.setCatId(id);
        goodsAttr.setName(goodsAttrDTO.getName());
        goodsAttr.setSel(goodsAttrDTO.getSel());
        goodsAttr.setWrite("only".equals(goodsAttrDTO.getSel()) ? "manual" : "list");
        goodsAttr.setVals(goodsAttrDTO.getVals() == null ? "" : goodsAttrDTO.getVals());
        int i = goodsAttrMapper.insertSelective(goodsAttr);
        if (i > 0) {
            return APIResponse.created();
        } else {
            return APIResponse.fail();
        }
    }

    /**
     * 删除参数
     *
     * @param id     分类 ID
     * @param attrId 参数 ID
     * @return 删除的属性
     */
    @Override
    public APIResponse<GoodsAttr> deleteAttribute(Integer id, Integer attrId) {
        goodsAttrMapper.deleteByPrimaryKey(attrId);
        return APIResponse.deleted();
    }

    /**
     * 根据 ID 查询参数
     *
     * @param id     分类 ID
     * @param attrId 属性 ID
     * @param sel    [only,many]
     * @param vals   商品对应的属性值
     * @return 参数
     */
    @Override
    public APIResponse<GoodsAttr> selectAttributeById(Integer id, Integer attrId, String sel, String vals) {
        GoodsAttr goodsAttr = goodsAttrMapper.selectByPrimaryKey(attrId);
        return APIResponse.success(goodsAttr);
    }

    /**
     * 编辑提交参数
     *
     * @param id        分类 ID
     * @param attrId    属性 ID
     * @param goodsAttr 新属性
     * @return 新参数
     */
    @Override
    public APIResponse<GoodsAttr> editAttribute(Integer id, Integer attrId, GoodsAttr goodsAttr) {
        goodsAttr.setId(attrId);
        goodsAttrMapper.updateByPrimaryKeySelective(goodsAttr);
        return APIResponse.updated();
    }
}
