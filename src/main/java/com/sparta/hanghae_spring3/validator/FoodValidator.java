package com.sparta.hanghae_spring3.validator;

import com.sparta.hanghae_spring3.dto.FoodDto;

public class FoodValidator {
    public static void validateFoodInput(FoodDto requestDto) {
        String name = requestDto.getName();
        Long price = requestDto.getPrice();

        if(price < 100) {
            throw new IllegalArgumentException("100원 미만 에러");
        }
        if(price > 1000000) {
            throw new IllegalArgumentException("1,000,000원 초과 에러");
        }
        if(price % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력 안 됨 에러");
        }

    }
}
