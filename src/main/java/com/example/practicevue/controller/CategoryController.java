package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Category;
import com.example.practicevue.model.CategoryDTO;
import com.example.practicevue.service.CategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zcy
 * @date 2020/12/4
 */
@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public APIResponse<PageInfo<CategoryDTO>> goodsCategoryDataList(@RequestParam(required = false) String type, CategoryDTO categoryDTO) {
        return APIResponse.success(categoryService.goodsCategoryDataList(type, categoryDTO));
    }

    @RequestMapping(method = RequestMethod.POST)
    public APIResponse<Category> createGoodsCategory(@RequestBody Category category) {
        return categoryService.createGoodsCategory(category);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public APIResponse<Category> selectGoodsCategoryById(@PathVariable Integer id) {
        return categoryService.selectGoodsCategoryById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public APIResponse<Category> editGoodsCategory(@PathVariable Integer id, @RequestBody Map<String, String> categoryInfo) {
        String categoryName = categoryInfo.get("name");
        return categoryService.editGoodsCategory(id, categoryName);
    }

    @RequestMapping(path = "/{id}/{isDelete}", method = RequestMethod.DELETE)
    public APIResponse<Category> deleteGoodsCategory(@PathVariable Integer id, @PathVariable Boolean isDelete) {
        return categoryService.deleteOrRecoveryGoodsCategory(id, isDelete);
    }
}
