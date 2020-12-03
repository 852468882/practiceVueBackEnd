package com.example.practicevue.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_user`")
public class User {
    /**
     * 自增id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 登录名
     */
    @Column(name = "`username`")
    private String username;

    /**
     * qq官方唯一编号信息
     */
    @Column(name = "`qq_open_id`")
    private String qqOpenId;

    /**
     * 登录密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "`user_email`")
    private String userEmail;

    /**
     * 新用户注册邮件激活唯一校验码
     */
    @Column(name = "`user_email_code`")
    private String userEmailCode;

    /**
     * 新用户是否已经通过邮箱激活帐号
     */
    @Column(name = "`is_active`")
    private String isActive;

    /**
     * 性别
     */
    @Column(name = "`user_sex`")
    private String userSex;

    /**
     * qq
     */
    @Column(name = "`user_qq`")
    private String userQq;

    /**
     * 手机
     */
    @Column(name = "`user_tel`")
    private String userTel;

    /**
     * 学历
     */
    @Column(name = "`user_xueli`")
    private String userXueli;

    /**
     * 爱好
     */
    @Column(name = "`user_hobby`")
    private String userHobby;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 简介
     */
    @Column(name = "`user_introduce`")
    private String userIntroduce;
}