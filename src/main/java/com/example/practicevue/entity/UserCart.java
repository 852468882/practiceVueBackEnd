package com.example.practicevue.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`sp_user_cart`")
public class UserCart {
    /**
     * 主键
     */
    @Column(name = "`cart_id`")
    private Integer cartId;

    /**
     * 学员id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`created_time`")
    private Date createdTime;

    @Column(name = "`updated_time`")
    private Date updatedTime;

    @Column(name = "`delete_time`")
    private Date deleteTime;

    /**
     * 购物车详情信息，二维数组序列化信息
     */
    @Column(name = "`cart_info`")
    private String cartInfo;
}