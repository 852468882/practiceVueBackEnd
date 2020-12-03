package com.example.practicevue.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_goods_attr`")
public class GoodsAttr {
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