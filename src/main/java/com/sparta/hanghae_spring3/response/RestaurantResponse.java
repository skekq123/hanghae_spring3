package com.sparta.hanghae_spring3.response;

import com.sparta.hanghae_spring3.model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantResponse {
        private Long id;
        private String name;
        private Long minOrderPrice;
        private Long deliveryFee;

        public RestaurantResponse(Restaurant restaurant) {
                this.id = restaurant.getId();
                this.name = restaurant.getName();
                this.minOrderPrice = restaurant.getMinOrderPrice();
                this.deliveryFee = restaurant.getDeliveryFee();
        }
}
