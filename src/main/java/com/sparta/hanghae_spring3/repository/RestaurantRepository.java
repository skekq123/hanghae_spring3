package com.sparta.hanghae_spring3.repository;

import com.sparta.hanghae_spring3.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
