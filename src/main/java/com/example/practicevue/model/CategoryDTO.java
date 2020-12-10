package com.example.practicevue.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryDTO extends BaseDTO{
    private String name;
    private Integer pid;
    private Integer level;
    private Boolean deleted;
    private String icon;
    private String src;

    private List<CategoryDTO> children;
}
