package com.example.practicevue.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_goods`")
public class Goods {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 商品名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 商品价格
     */
    @Column(name = "`price`")
    private BigDecimal price;

    /**
     * 商品数量
     */
    @Column(name = "`number`")
    private Integer number;

    /**
     * 商品重量
     */
    @Column(name = "`weight`")
    private Short weight;

    /**
     * 类型id
     */
    @Column(name = "`cat_id`")
    private Short catId;

    /**
     * 图片logo大图
     */
    @Column(name = "`big_logo`")
    private String bigLogo;

    /**
     * 图片logo小图
     */
    @Column(name = "`small_logo`")
    private String smallLogo;

    /**
     * 0:正常  1:删除
     */
    @Column(name = "`is_del`")
    private String isDel;

    /**
     * 添加商品时间
     */
    @Column(name = "`add_time`")
    private Integer addTime;

    /**
     * 修改商品时间
     */
    @Column(name = "`upd_time`")
    private Integer updTime;

    /**
     * 软删除标志字段
     */
    @Column(name = "`delete_time`")
    private Integer deleteTime;

    /**
     * 一级分类id
     */
    @Column(name = "`cat_one_id`")
    private Short catOneId;

    /**
     * 二级分类id
     */
    @Column(name = "`cat_two_id`")
    private Short catTwoId;

    /**
     * 三级分类id
     */
    @Column(name = "`cat_three_id`")
    private Short catThreeId;

    /**
     * 热卖数量
     */
    @Column(name = "`hot_mumber`")
    private Integer hotMumber;

    /**
     * 是否促销
     */
    @Column(name = "`is_promote`")
    private Short isPromote;

    /**
     * 商品状态 0: 未通过 1: 审核中 2: 已审核
     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 商品详情介绍
     */
    @Column(name = "`introduce`")
    private String introduce;
}