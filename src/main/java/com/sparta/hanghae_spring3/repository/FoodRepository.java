package com.sparta.hanghae_spring3.repository;

import com.sparta.hanghae_spring3.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);
    boolean existsByNameAndRestaurantId(String name, Long restaurantId);
}
