package com.example.practicevue.service;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Order;
import com.example.practicevue.model.OrderDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author zcy
 * @date 2020/12/23
 */
public interface OrderService {
    /**
     * 获取订单列表
     */
    APIResponse<PageInfo<Order>> getOrderList(OrderDTO orderDTO);
}
