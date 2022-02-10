package com.sparta.hanghae_spring3.request;

import com.sparta.hanghae_spring3.model.OrderFood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private Long restaurantId;
    private List<OrderFood> foods;
}
