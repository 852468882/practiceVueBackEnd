package com.example.practicevue.controller;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Order;
import com.example.practicevue.model.OrderDTO;
import com.example.practicevue.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zcy
 * @date 2020/12/23
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public APIResponse<PageInfo<Order>> orderList(OrderDTO orderDTO) {
        return orderService.getOrderList(orderDTO);
    }

    @RequestMapping(path = "/updateAddress/{id}", method = RequestMethod.POST)
    public APIResponse<Order> updateConsigneeAddr(@PathVariable Integer id, @RequestBody String newAddress){
        return orderService.updateConsigneeAddr(id, newAddress);
    }
}
