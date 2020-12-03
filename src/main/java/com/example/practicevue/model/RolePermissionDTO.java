package com.example.practicevue.model;

import lombok.Data;

import java.util.List;

/**
 * @author zcy
 * @date 2020/11/17
 */
@Data
public class RolePermissionDTO {
    private Integer id;
    private String roleName;
    private String roleDesc;
    private List<MenusDTO> children;
}
