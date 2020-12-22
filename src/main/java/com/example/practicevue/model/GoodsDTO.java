package com.example.practicevue.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zcy
 * @date 2020/12/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsDTO extends BaseDTO{
    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 商品重量
     */
    private Integer weight;

    /**
     * 类型id
     */
    private Integer catId;

    /**
     * 图片logo大图
     */
    private String bigLogo;

    /**
     * 图片logo小图
     */
    private String smallLogo;

    /**
     * 0:正常  1:删除
     */
    private String isDel;

    /**
     * 添加商品时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;

    /**
     * 修改商品时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updTime;

    /**
     * 软删除标志字段
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deleteTime;

    /**
     * 一级分类id
     */
    private Integer catOneId;

    /**
     * 二级分类id
     */
    private Integer catTwoId;

    /**
     * 三级分类id
     */
    private Integer catThreeId;

    /**
     * 热卖数量
     */
    private Integer hotNumber;

    /**
     * 是否促销
     */
    private Integer isPromote;

    /**
     * 商品状态 0: 未通过 1: 审核中 2: 已审核
     */
    private Integer state;

    /**
     * 商品详情介绍
     */
    private String introduce;


    /**
     * 以为','分割的分类列表
     */
    private String category;
    private List<GoodsPicsDTO> pics;
    private List<AttributeDTO> attrs;
}
