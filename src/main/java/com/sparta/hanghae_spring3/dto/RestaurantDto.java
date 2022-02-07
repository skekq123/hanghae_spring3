package com.sparta.hanghae_spring3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RestaurantDto {
    String name;
    Long minOrderPrice;
    Long deliveryFee;
}
