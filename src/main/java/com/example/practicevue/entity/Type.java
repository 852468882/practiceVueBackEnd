package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_type`")
public class Type {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Short id;

    /**
     * 类型名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 删除时间标志
     */
    @Column(name = "`delete_time`")
    private Integer deleteTime;
}