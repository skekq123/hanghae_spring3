package com.sparta.hanghae_spring3.controller;

import com.sparta.hanghae_spring3.request.OrderRequest;
import com.sparta.hanghae_spring3.response.OrderResponse;
import com.sparta.hanghae_spring3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public OrderResponse registerOrder(@RequestBody OrderRequest request) {
        return orderService.registerOrder(request);
    }

    @GetMapping("/orders")
    public List<OrderResponse> getOrders(){
        return orderService.getOrders();
    }
}
