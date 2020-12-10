package com.example.practicevue.mapper;

import com.example.practicevue.entity.Category;
import com.example.practicevue.model.CategoryDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

    /**
     * 获取顶级分类
     */
    List<CategoryDTO> getSuperCategories();

    /**
     * 获取所有分类
     */
    List<CategoryDTO> getAllCategoriesByLevel(List<Integer> levelList);

    /**
     * 批量删除/恢复分类
     */
    int deleteOrRecoveryCategoriesByIds(@Param("list") List<Integer> ids, @Param("isDelete") Integer isDelete);
}