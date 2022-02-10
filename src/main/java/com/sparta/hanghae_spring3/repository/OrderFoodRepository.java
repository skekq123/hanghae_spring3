package com.sparta.hanghae_spring3.repository;

import com.sparta.hanghae_spring3.model.OrderFood;
import com.sparta.hanghae_spring3.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
    List<OrderFood> findOrderFoodsByOrders(Orders orders);
}
