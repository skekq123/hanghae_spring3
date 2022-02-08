package com.sparta.hanghae_spring3.controller;

import com.sparta.hanghae_spring3.dto.FoodDto;
import com.sparta.hanghae_spring3.response.FoodResponse;
import com.sparta.hanghae_spring3.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> request) {

        foodService.registerFood(restaurantId, request);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponse> getFoods(@PathVariable Long restaurantId) {
        return foodService.getFoods(restaurantId);
    }
}