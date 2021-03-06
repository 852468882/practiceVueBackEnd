package com.example.practicevue.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author zcy
 * @date 2020/11/9
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerDTO extends BaseDTO{
    private String username;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer roleId;

    private String mobile;

    private String email;

    private Integer state;

    private Boolean status;
    private String roleName;
}
