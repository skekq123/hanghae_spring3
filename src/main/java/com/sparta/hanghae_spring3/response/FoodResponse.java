package com.sparta.hanghae_spring3.response;

import com.sparta.hanghae_spring3.model.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodResponse {
    Long id;
    String name;
    Long price;

    public FoodResponse(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.price = food.getPrice();
    }
}
