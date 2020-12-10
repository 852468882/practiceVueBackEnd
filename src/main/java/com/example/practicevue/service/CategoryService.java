package com.example.practicevue.service;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Category;
import com.example.practicevue.model.CategoryDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author zcy
 * @date 2020/12/4
 */
public interface CategoryService {

    /**
     * 商品分类数据列表
     *
     * @param type        值：1，2，3 分别表示显示一层二层三层分类列表
     * @param categoryDTO 参数
     * @return 商品分类数据列表
     */
    PageInfo<CategoryDTO> goodsCategoryDataList(String type, CategoryDTO categoryDTO);

    /**
     * 添加分类
     *
     * @param category 商品信息
     * @return 商品信息
     */
    APIResponse<Category> createGoodsCategory(Category category);

    /**
     * 根据 id 查询分类
     *
     * @param id id
     * @return 商品分类
     */
    APIResponse<Category> selectGoodsCategoryById(Integer id);

    /**
     * 根据 id 编辑提交分类
     *
     * @param id id
     * @return 修改信息
     */
    APIResponse<Category> editGoodsCategory(Integer id, String categoryName);

    /**
     * 根据 id 删除分类
     *
     * @param id       id
     * @param isDelete 是否是删除操作
     * @return 删除信息
     */
    APIResponse<Category> deleteOrRecoveryGoodsCategory(Integer id, Boolean isDelete);
}
