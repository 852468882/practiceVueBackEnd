package com.example.practicevue.service;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.GoodsAttr;
import com.example.practicevue.model.GoodsAttrDTO;

import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
public interface AttributeService {

    /**
     * 参数列表
     *
     * @param id  分类 ID 不能为空，携带在url中
     * @param sel [only,many] 不能为空,通过 only 或 many 来获取分类静态参数还是动态参数
     * @return 参数列表
     */
    APIResponse<List<GoodsAttr>> attributesList(Integer id, String sel);

    /**
     * 添加动态参数或者静态属性
     *
     * @param id           分类 ID 不能为空，携带在url中
     * @param goodsAttrDTO 添加信息
     * @return 添加信息
     */
    APIResponse<GoodsAttr> createAttribute(Integer id, GoodsAttrDTO goodsAttrDTO);

    /**
     * 删除参数
     *
     * @param id     分类 ID
     * @param attrId attrId参数 ID
     * @return 删除的属性
     */
    APIResponse<GoodsAttr> deleteAttribute(Integer id, Integer attrId);

    /**
     * 根据 ID 查询参数
     *
     * @param id     分类 ID
     * @param attrId 属性 ID
     * @param sel    [only,many]
     * @param vals   商品对应的属性值
     * @return 参数
     */
    APIResponse<GoodsAttr> selectAttributeById(Integer id, Integer attrId, String sel, String vals);

    /**
     * 编辑提交参数
     *
     * @param id        分类 ID
     * @param attrId    属性 ID
     * @param goodsAttr 新属性
     * @return 新参数
     */
    APIResponse<GoodsAttr> editAttribute(Integer id, Integer attrId, GoodsAttr goodsAttr);
}
