package com.sparta.hanghae_spring3.service;

import com.sparta.hanghae_spring3.model.Food;
import com.sparta.hanghae_spring3.model.OrderFood;
import com.sparta.hanghae_spring3.model.Orders;
import com.sparta.hanghae_spring3.model.Restaurant;
import com.sparta.hanghae_spring3.repository.FoodRepository;
import com.sparta.hanghae_spring3.repository.OrderFoodRepository;
import com.sparta.hanghae_spring3.repository.OrderRepository;
import com.sparta.hanghae_spring3.repository.RestaurantRepository;
import com.sparta.hanghae_spring3.request.OrderRequest;
import com.sparta.hanghae_spring3.response.OrderFoodResponse;
import com.sparta.hanghae_spring3.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderFoodRepository orderFoodRepository;

    @Autowired
    public OrderService (OrderRepository orderRepository, RestaurantRepository restaurantRepository, FoodRepository foodRepository, OrderFoodRepository orderFoodRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.orderFoodRepository = orderFoodRepository;
    }

    @Transactional
    public OrderResponse registerOrder(OrderRequest request) {
        Restaurant restaurant = restaurantRepository.getById(request.getRestaurantId());

        List<OrderFoodResponse> orderFoodResponses = new ArrayList<>();
        List<OrderFood> orderFoods = new ArrayList<>();
        Long totalPrice = 0L;

        for(OrderFood curOrderFood : request.getFoods()) {
            Food food = foodRepository.getById(curOrderFood.getId());
            Long quantity = curOrderFood.getQuantity();

            if(quantity < 0 || quantity > 100) throw new IllegalArgumentException("음식은 주문은 1개이상 100개이하 입니다.");
            OrderFood orderFood = new OrderFood(food, quantity);
            //System.out.println("오더아이디 : " + curOrderFood.getOrders().getId());
            orderFoodRepository.save(orderFood);
            orderFoods.add(orderFood);

            OrderFoodResponse orderFoodResponse = new OrderFoodResponse();

            orderFoodResponse.setName(food.getName());
            orderFoodResponse.setQuantity(quantity);
            Long price = food.getPrice() * quantity;
            orderFoodResponse.setPrice(price);

            totalPrice += price;
            orderFoodResponses.add(orderFoodResponse);
        }
        if(totalPrice < restaurant.getMinOrderPrice()) throw new IllegalArgumentException("최소 주문금액이상 주문");
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setRestaurantName(restaurant.getName());
        orderResponse.setDeliveryFee(restaurant.getDeliveryFee());
        orderResponse.setTotalPrice(totalPrice + restaurant.getDeliveryFee());
        orderResponse.setFoods(orderFoodResponses);
        Orders order = new Orders(restaurant.getName(), orderFoods, totalPrice+ restaurant.getDeliveryFee(), restaurant.getDeliveryFee());

        orderRepository.save(order);

        return orderResponse;
    }

    @Transactional
    public List<OrderResponse> getOrders() {
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<OrderFoodResponse> orderFoodResponses = new ArrayList<>();
        List<Orders> orders = orderRepository.findAll();
        for(Orders order : orders) {
            List<OrderFood> orderFoods = orderFoodRepository.findOrderFoodsByOrders(order); // 여기가 잘못
            System.out.println("오더푸드: " + orderFoods.size());
            for (OrderFood orderFood : orderFoods) {
                OrderFoodResponse orderFoodResponse = new OrderFoodResponse();
                orderFoodResponse.setName(orderFood.getFood().getName());
                orderFoodResponse.setQuantity(orderFood.getQuantity());
                Long totalPrice = orderFood.getQuantity() * orderFood.getFood().getPrice();
                orderFoodResponse.setPrice(totalPrice);

                orderFoodResponses.add(orderFoodResponse);
            }

            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setRestaurantName(order.getRestaurantName());
            orderResponse.setFoods(orderFoodResponses);
            orderResponse.setDeliveryFee(order.getDeliveryFee());
            orderResponse.setTotalPrice(order.getTotalPrice());

            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }
}
