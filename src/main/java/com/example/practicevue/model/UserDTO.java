package com.example.practicevue.model;

import lombok.Data;

import java.util.Date;

/**
 * @author zcy
 * @date 2020/11/9
 */
@Data
public class UserDTO {
    private Integer id;

    private String username;

    private String qqOpenId;

    private String password;

    private String userEmail;

    private String userEmailCode;

    private String isActive;

    private String userSex;

    private String userQq;

    private String userTel;

    private String userXueli;

    private String userHobby;

    private Date createTime;

    private Date updateTime;

    private String userIntroduce;
}
