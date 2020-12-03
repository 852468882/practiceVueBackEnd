package com.example.practicevue.view;

import lombok.Data;

import java.util.Date;

/**
 * @author zcy
 * @date 2020/11/9
 */
@Data
public class ManagerVO {
    private Integer id;

    private String mgName;

    private String mgPassword;

    private Date createTime;

    private Integer roleId;

    private String mgMobile;

    private String mgEmail;

    private Integer mgState;
}
