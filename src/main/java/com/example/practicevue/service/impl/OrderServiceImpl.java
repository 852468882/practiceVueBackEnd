package com.example.practicevue.service.impl;

import com.example.practicevue.common.APIResponse;
import com.example.practicevue.entity.Order;
import com.example.practicevue.mapper.OrderMapper;
import com.example.practicevue.model.OrderDTO;
import com.example.practicevue.service.OrderService;
import com.example.practicevue.utils.PageHelperUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zcy
 * @date 2020/12/23
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public APIResponse<PageInfo<Order>> getOrderList(OrderDTO orderDTO) {
        return APIResponse.success(PageHelperUtil.page(orderDTO.getPageNum(), orderDTO.getPageSize(), () -> orderMapper.selectAll()));
    }
}
