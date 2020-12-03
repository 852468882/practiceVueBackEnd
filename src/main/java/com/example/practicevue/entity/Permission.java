package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_permission`")
public class Permission {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Short id;

    /**
     * 权限名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 父id
     */
    @Column(name = "`pid`")
    private Short pid;

    /**
     * 控制器
     */
    @Column(name = "`controller`")
    private String controller;

    /**
     * 操作方法
     */
    @Column(name = "`method`")
    private String method;

    /**
     * 权限等级
     */
    @Column(name = "`level`")
    private String level;
}