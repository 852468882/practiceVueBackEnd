package com.example.practicevue.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_goods_cats`")
public class GoodsCats {
    /**
     * 分类id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 父级id
     */
    @Column(name = "`parent_id`")
    private Integer parentId;

    /**
     * 分类名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 是否显示
     */
    @Column(name = "`is_show`")
    private Byte isShow;

    /**
     * 分类排序
     */
    @Column(name = "`sort`")
    private Integer sort;

    /**
     * 数据标记
     */
    @Column(name = "`data_flag`")
    private Byte dataFlag;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Integer createTime;
}