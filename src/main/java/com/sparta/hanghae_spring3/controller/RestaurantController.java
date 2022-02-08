package com.sparta.hanghae_spring3.controller;

import com.sparta.hanghae_spring3.dto.RestaurantDto;
import com.sparta.hanghae_spring3.response.RestaurantResponse;
import com.sparta.hanghae_spring3.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant/register")
    public RestaurantResponse registerRestaurant(@RequestBody RestaurantDto request) {
        return restaurantService.registerRestaurant(request);
    }

    @GetMapping("/restaurants")
    public List<RestaurantResponse> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}
