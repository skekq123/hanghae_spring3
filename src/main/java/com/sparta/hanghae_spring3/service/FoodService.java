package com.sparta.hanghae_spring3.service;

import com.sparta.hanghae_spring3.dto.FoodDto;
import com.sparta.hanghae_spring3.response.FoodResponse;
import com.sparta.hanghae_spring3.model.Food;
import com.sparta.hanghae_spring3.model.Restaurant;
import com.sparta.hanghae_spring3.repository.FoodRepository;
import com.sparta.hanghae_spring3.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public void registerFood(Long restaurantId, List<FoodDto> request) {

        Restaurant restaurant = restaurantRepository.getById(restaurantId);
        for(FoodDto f : request) {
            Food food = new Food(f);
            food.setRestaurant(restaurant);
            if(foodRepository.existsByNameAndRestaurantId(food.getName(), restaurantId)) throw new IllegalArgumentException("음식 중복 에러");
            foodRepository.save(food);
        }
    }

    public List<FoodResponse> getFoods(Long retaurantId) {
        List<Food> foods = foodRepository.findAllByRestaurantId(retaurantId);
        List<FoodResponse> responses = new ArrayList<>();


        for(Food f : foods) {
            FoodResponse foodResponse = new FoodResponse(f);
            responses.add(foodResponse);
        }

        return responses;
    }
}
