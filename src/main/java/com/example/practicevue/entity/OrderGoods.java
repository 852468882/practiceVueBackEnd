package com.example.practicevue.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_order_goods`")
public class OrderGoods {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 订单id
     */
    @Column(name = "`order_id`")
    private Integer orderId;

    /**
     * 商品id
     */
    @Column(name = "`goods_id`")
    private Integer goodsId;

    /**
     * 商品单价
     */
    @Column(name = "`goods_price`")
    private BigDecimal goodsPrice;

    /**
     * 购买单个商品数量
     */
    @Column(name = "`goods_number`")
    private Byte goodsNumber;

    /**
     * 商品小计价格
     */
    @Column(name = "`goods_total_price`")
    private BigDecimal goodsTotalPrice;
}