package com.sparta.hanghae_spring3.repository;

import com.sparta.hanghae_spring3.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
