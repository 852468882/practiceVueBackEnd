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
    private String invoiceTitle;

    /**
     * 公司名称
     */
    @Column(name = "`fapiao_company`")
    private String invoiceCompany;

    /**
     * 发票内容
     */
    @Column(name = "`fapiao_content`")
    private String invoiceContent;

    /**
     * 订单状态： 0未付款、1已付款
     */
    @Column(name = "`pay_status`")
    private String payStatus;

    /**
     * 记录生成时间
     */
    @Column(name = "`create_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 记录修改时间
     */
    @Column(name = "`update_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * consignee收货人地址
     */
    @Column(name = "`consignee_addr`")
    private String consigneeAddr;
}