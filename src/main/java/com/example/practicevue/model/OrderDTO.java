package com.example.practicevue.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zcy
 * @date 2020/12/23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends BaseDTO{
    /**
     * 下订单会员id
     */
    private Integer userId;

    /**
     * 订单编号
     */
    private String number;

    /**
     * 订单总金额
     */
    private BigDecimal price;

    /**
     * 支付方式  0未支付 1支付宝  2微信  3银行卡
     */
    private String pay;

    /**
     * 订单是否已经发货
     */
    private String isSend;

    /**
     * 支付宝交易流水号码
     */
    private String tradeNo;

    /**
     * 发票抬头 个人 公司
     */
    private String invoiceTitle;

    /**
     * 公司名称
     */
    private String invoiceCompany;

    /**
     * 发票内容
     */
    private String invoiceContent;

    /**
     * 订单状态： 0未付款、1已付款
     */
    private String payStatus;

    /**
     * 记录生成时间
     */
    private Date createTime;

    /**
     * 记录修改时间
     */
    private Date updateTime;

    /**
     * consignee收货人地址
     */
    private String consigneeAddr;
}
