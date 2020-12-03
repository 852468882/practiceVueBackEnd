package com.example.practicevue.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_order`")
public class Order {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 下订单会员id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 订单编号
     */
    @Column(name = "`number`")
    private String number;

    /**
     * 订单总金额
     */
    @Column(name = "`price`")
    private BigDecimal price;

    /**
     * 支付方式  0未支付 1支付宝  2微信  3银行卡
     */
    @Column(name = "`pay`")
    private String pay;

    /**
     * 订单是否已经发货
     */
    @Column(name = "`is_send`")
    private String isSend;

    /**
     * 支付宝交易流水号码
     */
    @Column(name = "`trade_no`")
    private String tradeNo;

    /**
     * 发票抬头 个人 公司
     */
    @Column(name = "`fapiao_title`")
    private String fapiaoTitle;

    /**
     * 公司名称
     */
    @Column(name = "`fapiao_company`")
    private String fapiaoCompany;

    /**
     * 发票内容
     */
    @Column(name = "`fapiao_content`")
    private String fapiaoContent;

    /**
     * 订单状态： 0未付款、1已付款
     */
    @Column(name = "`pay_status`")
    private String payStatus;

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

    /**
     * consignee收货人地址
     */
    @Column(name = "`consignee_addr`")
    private String consigneeAddr;
}