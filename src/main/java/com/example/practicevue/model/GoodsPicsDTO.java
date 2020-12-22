package com.example.practicevue.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zcy
 * @date 2020/12/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsPicsDTO extends BaseDTO{
    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 相册大图800*800
     */
    private String big;

    /**
     * 相册中图350*350
     */
    private String mid;

    /**
     * 相册小图50*50
     */
    private String small;

    private String pic;
}
