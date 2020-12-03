package com.example.practicevue.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_report_1`")
public class ReportOne {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户数
     */
    @Column(name = "`rp1_user_count`")
    private Integer rp1UserCount;

    /**
     * 地区
     */
    @Column(name = "`rp1_area`")
    private String rp1Area;

    @Column(name = "`rp1_date`")
    private Date rp1Date;
}