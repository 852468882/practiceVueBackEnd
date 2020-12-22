package com.example.practicevue.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zcy
 * @date 2020/12/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsAttrDTO extends BaseDTO{
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 外键，商品id
     */
    private Integer goodsId;

    /**
     * 外键，类型id
     */
    private Integer catId;

    /**
     * only:输入框(唯一)  many:后台下拉列表/前台单选框
     */
    private String sel;

    /**
     * manual:手工录入  list:从列表选择
     */
    private String write;

    /**
     * 该属性需要额外增加的价钱
     */
    private BigDecimal addPrice;

    /**
     * 删除时间标志
     */
    private Date deleteTime;

    /**
     * 可选值列表信息,例如颜色：白色,红色,绿色,多个可选值通过逗号分隔
     */
    private String vals;

    /**
     * 商品属性值
     */
    private String attrValue;
}
