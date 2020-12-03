package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_category`")
public class Category {
    /**
     * 分类唯一ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 分类名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 分类父ID
     */
    @Column(name = "`pid`")
    private Integer pid;

    /**
     * 分类层级 0: 顶级 1:二级 2:三级
     */
    @Column(name = "`level`")
    private Integer level;

    /**
     * 是否删除 1为删除
     */
    @Column(name = "`deleted`")
    private Integer deleted;

    @Column(name = "`icon`")
    private String icon;

    @Column(name = "`src`")
    private String src;
}