package com.example.practicevue.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zcy
 * @date 2020/11/11
 */
@Setter
@Getter
public class BaseDTO {
    private Integer id;

    private Integer pageNum;
    private Integer pageSize;
}
