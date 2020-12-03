package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_express`")
public class Express {
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
     * 订单快递公司名称
     */
    @Column(name = "`com`")
    private String com;

    /**
     * 快递单编号
     */
    @Column(name = "`nu`")
    private String nu;

    /**
     * 记录生成时间
     */
    @Column(name = "`create_time`")
    private Integer createTime;

    /**
     * 记录修改时间
     */
    @Column(name = "`update_time`")
    private Integer updateTime;
}