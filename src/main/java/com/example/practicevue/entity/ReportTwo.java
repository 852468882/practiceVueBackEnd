package com.example.practicevue.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_report_2`")
public class ReportTwo {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`rp2_page`")
    private String rp2Page;

    @Column(name = "`rp2_count`")
    private Integer rp2Count;

    @Column(name = "`rp2_date`")
    private Date rp2Date;
}