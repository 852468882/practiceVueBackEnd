package com.example.practicevue.model;

import lombok.Data;

import java.util.List;

/**
 * @author zcy
 * @date 2020/11/11
 */
@Data
public class MenusDTO {
    private Integer id;
    private String authName;
    private String path;
    private Integer pid;
    private List<MenusDTO> children;
}
