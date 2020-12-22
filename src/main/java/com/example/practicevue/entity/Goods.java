package com.example.practicevue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

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
    private Integer weight;

    /**
     * 类型id
     */
    @Column(name = "`cat_id`")
    private Integer catId;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;

    /**
     * 修改商品时间
     */
    @Column(name = "`upd_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updTime;

    /**
     * 软删除标志字段
     */
    @Column(name = "`delete_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deleteTime;

    /**
     * 一级分类id
     */
    @Column(name = "`cat_one_id`")
    private Integer catOneId;

    /**
     * 二级分类id
     */
    @Column(name = "`cat_two_id`")
    private Integer catTwoId;

    /**
     * 三级分类id
     */
    @Column(name = "`cat_three_id`")
    private Integer catThreeId;

    /**
     * 热卖数量
     */
    @Column(name = "`hot_number`")
    private Integer hotNumber;

    /**
     * 是否促销
     */
    @Column(name = "`is_promote`")
    private Integer isPromote;

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