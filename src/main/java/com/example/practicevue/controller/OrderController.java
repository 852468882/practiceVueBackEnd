package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Order;
import com.example.practicevue.model.OrderDTO;
import com.example.practicevue.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcy
 * @date 2020/12/23
 */
@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public APIResponse<PageInfo<Order>> orderList(OrderDTO orderDTO) {
        return orderService.getOrderList(orderDTO);
    }
}
