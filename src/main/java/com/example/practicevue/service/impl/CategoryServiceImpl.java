package com.example.practicevue.service.impl;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Category;
import com.example.practicevue.mapper.CategoryMapper;
import com.example.practicevue.model.CategoryDTO;
import com.example.practicevue.service.CategoryService;
import com.example.practicevue.utils.PageHelperUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<CategoryDTO> goodsCategoryDataList(String type, CategoryDTO categoryDTO) {
        Integer pageNum = categoryDTO.getPageNum();
        Integer pageSize = categoryDTO.getPageSize();
        if (StringUtils.isBlank(type)){
            type = "default";
        }
        switch (type) {
            case "1":
                return PageHelperUtil.page(pageNum, pageSize, () -> categoryMapper.getSuperCategories());
            case "2":
                return new PageInfo<>(getGoodsCategoryDataList(1));
            case "3":
                return PageHelperUtil.page(pageNum, pageSize, () -> getGoodsCategoryDataList(1, 2));
            default:
                return new PageInfo<>(getGoodsCategoryDataList(1, 2));
        }
    }

    @Override
    public APIResponse<Category> createGoodsCategory(Category category) {
        APIResponse<Category> apiResponse = validateCreateGoodsCategory(category);
        if (apiResponse.getStatus() == 200) {
            int i = categoryMapper.insertSelective(category);
            if (i > 0) {
                apiResponse = APIResponse.created();
            } else {
                apiResponse = APIResponse.fail();
            }
        }
        return apiResponse;
    }

    @Override
    public APIResponse<Category> selectGoodsCategoryById(Integer id) {
        return APIResponse.success(categoryMapper.selectByPrimaryKey(id));
    }

    @Override
    public APIResponse<Category> editGoodsCategory(Integer id, String categoryName) {
        APIResponse<Category> apiResponse = validateEditGoodsCategory(id, categoryName);
        if (apiResponse.getStatus() == 200) {
            Category category = new Category();
            category.setId(id);
            category.setName(categoryName);
            int i = categoryMapper.updateByPrimaryKeySelective(category);
            if (i > 0) {
                apiResponse = APIResponse.updated();
            } else {
                apiResponse = APIResponse.fail();
            }
        }
        return apiResponse;
    }

    @Override
    public APIResponse<Category> deleteOrRecoveryGoodsCategory(Integer id, Boolean isDelete) {
        APIResponse<Category> apiResponse;

        Example example = new Example(Category.class);
        example.selectProperties("id", "pid");
        List<Category> allCategories = categoryMapper.selectByExample(example);

        if (isDelete) {
            List<Integer> deleteIds = getDeleteIds(id, allCategories);
            int i = categoryMapper.deleteOrRecoveryCategoriesByIds(deleteIds, 1);
            if (i > 0) {
                apiResponse = APIResponse.ok();
            } else {
                apiResponse = APIResponse.fail();
            }
        } else {
            List<Integer> recoveryIds = getRecoveryIds(id, allCategories);
            int i = categoryMapper.deleteOrRecoveryCategoriesByIds(recoveryIds, 0);
            if (i > 0) {
                apiResponse = APIResponse.ok();
            } else {
                apiResponse = APIResponse.fail();
            }
        }
        return apiResponse;
    }

    /**
     * 获取商品分类列表
     *
     * @param levels 层级分类
     * @return 数据列表
     */
    private List<CategoryDTO> getGoodsCategoryDataList(Integer... levels) {
        List<Integer> levelList = new ArrayList<>(Arrays.asList(levels));
        List<CategoryDTO> superCategories = categoryMapper.getSuperCategories();
        List<CategoryDTO> allCategories = categoryMapper.getAllCategoriesByLevel(levelList);
        for (CategoryDTO superCategory : superCategories) {
            List<CategoryDTO> children = childGoodsCategory(superCategory.getId(), allCategories);
            superCategory.setChildren(children);
        }
        return superCategories;
    }

    /**
     * 递归获取商品子分类数据
     *
     * @param id            外层数据的 id ，用于匹配所有数据的 pid
     * @param allCategories 所有数据
     * @return children
     */
    private List<CategoryDTO> childGoodsCategory(Integer id, List<CategoryDTO> allCategories) {
        List<CategoryDTO> children = new ArrayList<>();
        for (CategoryDTO category : allCategories) {
            if (category.getPid().equals(id)) {
                children.add(category);
            }
        }

        for (CategoryDTO categoryDTO : children) {
            List<CategoryDTO> child = childGoodsCategory(categoryDTO.getId(), allCategories);
            if (CollectionUtils.isNotEmpty(child)) {
                categoryDTO.setChildren(child);
            }
        }

        return children;
    }

    /**
     * 验证创建商品分类
     *
     * @param category 商品分类信息
     * @return 验证结果
     */
    private APIResponse<Category> validateCreateGoodsCategory(Category category) {
        StringBuilder errorMessage = new StringBuilder();
        if (category.getPid() == null) {
            errorMessage.append("分类父级ID不能为空;");
        }
        if (category.getName() == null || "".equals(category.getName())) {
            errorMessage.append("分类名称不能为空;");
        }
        if (category.getLevel() == null) {
            errorMessage.append("分类层级不能为空;");
        }
        if (StringUtils.isNotBlank(errorMessage)) {
            return APIResponse.fail(errorMessage.toString());
        } else {
            return APIResponse.success("验证通过");
        }
    }

    /**
     * 验证编辑商品分类
     *
     * @param id           商品分类ID
     * @param categoryName 商品分类名称
     * @return 验证结果
     */
    private APIResponse<Category> validateEditGoodsCategory(Integer id, String categoryName) {
        StringBuilder errorMessage = new StringBuilder();
        if (id == null || id == 0) {
            errorMessage.append("分类ID不能为空;");
        }
        if (StringUtils.isBlank(categoryName)) {
            errorMessage.append("分类名称不能为空;");
        }
        if (StringUtils.isNotBlank(errorMessage)) {
            return APIResponse.fail(errorMessage.toString());
        } else {
            return APIResponse.success("验证通过");
        }
    }

    /**
     * 获取删除ID列表
     *
     * @param pid           父级ID
     * @param allCategories 所有分类ID
     * @return ID列表
     */
    private List<Integer> getDeleteIds(Integer pid, List<Category> allCategories) {
        List<Integer> ids = new ArrayList<>();
        ids.add(pid);
        for (Category category : allCategories) {
            if (category.getPid().equals(pid)) {
                ids.addAll(getDeleteIds(category.getId(), allCategories));
            }
        }
        return ids;
    }

    /**
     * 获取恢复列表ID
     *
     * @param id            分类ID
     * @param allCategories 所有分类ID
     * @return ID列表
     */
    private List<Integer> getRecoveryIds(Integer id, List<Category> allCategories) {
        List<Integer> ids = new ArrayList<>();
        if (id.equals(0)) {
            return ids;
        }
        ids.add(id);
        for (Category category : allCategories) {
            if (category.getId().equals(id)) {
                ids.addAll(getRecoveryIds(category.getPid(), allCategories));
            }
        }
        return ids;
    }
}
