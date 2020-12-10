package com.example.practicevue.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author zcy
 * @date 2020/12/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttributeDTO extends BaseDTO{
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 属性id
     */
    private Short attrId;

    /**
     * 该属性需要额外增加的价钱
     */
    private BigDecimal addPrice;

    /**
     * 商品对应属性的值
     */
    private String attrValue;
}
