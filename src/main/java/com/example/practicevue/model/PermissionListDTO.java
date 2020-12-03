package com.example.practicevue.model;

import lombok.Data;

/**
 * @author zcy
 * @date 2020/11/13
 */
@Data
public class PermissionListDTO {
    private Integer id;
    private String authName;
    private String level;
    private String path;
    private Integer pid;
}
