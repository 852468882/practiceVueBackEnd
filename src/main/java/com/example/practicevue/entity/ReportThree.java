package com.example.practicevue.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_report_3`")
public class ReportThree {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户来源
     */
    @Column(name = "`rp3_src`")
    private String rp3Src;

    /**
     * 数量
     */
    @Column(name = "`rp3_count`")
    private Integer rp3Count;

    @Column(name = "`rp3_date`")
    private Date rp3Date;
}