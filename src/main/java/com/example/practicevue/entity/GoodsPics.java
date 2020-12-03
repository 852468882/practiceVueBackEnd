package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_goods_pics`")
public class GoodsPics {
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
     * 相册大图800*800
     */
    @Column(name = "`big`")
    private String big;

    /**
     * 相册中图350*350
     */
    @Column(name = "`mid`")
    private String mid;

    /**
     * 相册小图50*50
     */
    @Column(name = "`small`")
    private String small;
}