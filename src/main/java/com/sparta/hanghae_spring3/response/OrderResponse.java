package com.sparta.hanghae_spring3.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponse {
    private String restaurantName;
    private List<OrderFoodResponse> foods;
    private Long deliveryFee;
    private Long totalPrice;
}
