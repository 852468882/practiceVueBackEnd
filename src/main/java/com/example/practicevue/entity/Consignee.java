package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_consignee`")
public class Consignee {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 会员id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 收货人名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 收货人地址
     */
    @Column(name = "`address`")
    private String address;

    /**
     * 收货人电话
     */
    @Column(name = "`tel`")
    private String tel;

    /**
     * 邮编
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 删除时间
     */
    @Column(name = "`delete_time`")
    private Integer deleteTime;
}