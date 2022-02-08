package com.sparta.hanghae_spring3.model;

import com.sparta.hanghae_spring3.dto.RestaurantDto;
import com.sparta.hanghae_spring3.validator.RestaurantValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "restaurant_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    @OneToMany(mappedBy = "restaurant")
    List<Food> foods = new ArrayList<>();

    public Restaurant(RestaurantDto requestDto) {

        RestaurantValidator.validateRestaurantInput(requestDto);

        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}
