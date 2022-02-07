package com.sparta.hanghae_spring3.validator;

import com.sparta.hanghae_spring3.dto.RestaurantDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {
    public static void validateRestaurantInput(RestaurantDto requestDto) {
        String name = requestDto.getName();
        Long minOrderPrice = requestDto.getMinOrderPrice();
        Long deliveryFee = requestDto.getDeliveryFee();

        //기본 배달비
        if(deliveryFee < 0) {
            throw new IllegalArgumentException("0원 미만 에러");
        }
        if(deliveryFee > 10000) {
            throw new IllegalArgumentException("10,000원 초과 에러");
        }
        if(deliveryFee != 0 && (deliveryFee % 500 != 0)) {
            throw new IllegalArgumentException("500원 단위로 입력 안 됨 에러");
        }
        // 최소주문 가격
        if(minOrderPrice < 1000) {
            throw new IllegalArgumentException("1,000원 미만 에러");
        }
        if(minOrderPrice > 100000) {
            throw new IllegalArgumentException("100,000원 초과 에러");
        }
        if(minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력 안 됨 에러");
        }
    }
}
