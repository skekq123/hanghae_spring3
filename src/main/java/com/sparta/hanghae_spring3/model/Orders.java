package com.sparta.hanghae_spring3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Orders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany
    @JoinColumn(name="orders_id")
    private List<OrderFood> orderFoods;

    @Column(nullable = false)
    private Long totalPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    public Orders(String restaurantName, List<OrderFood> orderFoods, Long totalPrice, Long deliveryFee) {
        this.restaurantName = restaurantName;
        this.orderFoods = orderFoods;
        this.totalPrice = totalPrice;
        this.deliveryFee = deliveryFee;
    }

}