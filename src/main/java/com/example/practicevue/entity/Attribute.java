package com.example.practicevue.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "`sp_attribute`")
public class Attribute {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "`goods_id`")
    private Integer goodsId;

    /**
     * 属性id
     */
    @Column(name = "`attr_id`")
    private Short attrId;

    /**
     * 该属性需要额外增加的价钱
     */
    @Column(name = "`add_price`")
    private BigDecimal addPrice;

    /**
     * 商品对应属性的值
     */
    @Column(name = "`attr_value`")
    private String attrValue;
}