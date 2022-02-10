package com.sparta.hanghae_spring3.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderFoodResponse {
    private String name;
    private Long quantity;
    private Long price;
}
