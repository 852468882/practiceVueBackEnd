package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_role`")
public class Role {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色名称
     */
    @Column(name = "`role_name`")
    private String roleName;

    /**
     * 权限ids,1,2,5
     */
    @Column(name = "`ps_ids`")
    private String psIds;

    /**
     * 控制器-操作,控制器-操作,控制器-操作
     */
    @Column(name = "`ps_ca`")
    private String psCa;

    @Column(name = "`role_desc`")
    private String roleDesc;
}