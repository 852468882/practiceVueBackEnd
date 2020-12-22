package com.example.practicevue.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
     * 属性名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 外键，类型id
     */
    @Column(name = "`cat_id`")
    private Integer catId;

    /**
     * only:输入框(唯一)  many:后台下拉列表/前台单选框
     */
    @Column(name = "`sel`")
    private String sel;

    /**
     * manual:手工录入  list:从列表选择
     */
    @Column(name = "`write`")
    private String write;

    /**
     * 删除时间标志
     */
    @Column(name = "`delete_time`")
    private Date deleteTime;

    /**
     * 可选值列表信息,例如颜色：白色,红色,绿色,多个可选值通过逗号分隔
     */
    @Column(name = "`vals`")
    private String vals;
}