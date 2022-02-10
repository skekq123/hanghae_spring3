package com.sparta.hanghae_spring3.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.sparta.hanghae_spring3.dto.FoodDto;
import com.sparta.hanghae_spring3.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="food")
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="food_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Food(FoodDto request) {
        FoodValidator.validateFoodInput(request);
        this.name = request.getName();
        this.price = request.getPrice();
    }

    public void setRestaurant(Restaurant restaurant) {
        if(this.restaurant != null) {
            this.restaurant.getFoods().remove(this);
        }
        this.restaurant = restaurant;
        restaurant.getFoods().add(this);
    }
}
