package com.sparta.hanghae_spring3.service;

import com.sparta.hanghae_spring3.dto.RestaurantDto;
import com.sparta.hanghae_spring3.response.RestaurantResponse;
import com.sparta.hanghae_spring3.model.Restaurant;
import com.sparta.hanghae_spring3.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantResponse> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<RestaurantResponse> responses = new ArrayList<>();

        for(Restaurant r : restaurants) {
            RestaurantResponse restaurantResponse = new RestaurantResponse(r);
            responses.add(restaurantResponse);
        }
        return responses;
    }

    public RestaurantResponse registerRestaurant(RestaurantDto request) {
        Restaurant restaurant = new Restaurant(request);
        restaurantRepository.save(restaurant);

        return new RestaurantResponse(restaurant);
    }
}
