package com.sparta.hanghae_spring3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="orderFood")
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Food food;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne
    private Orders orders;

    public OrderFood(Food food, Long quantity) {
        this.food = food;
        this.quantity = quantity;
    }
}
