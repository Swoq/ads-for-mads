package com.swoqe.adsformads.controller;

import com.swoqe.adsformads.ResourceRoot;
import com.swoqe.adsformads.model.Order;
import com.swoqe.adsformads.model.dto.OrderDto;
import com.swoqe.adsformads.model.dto.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final WebClient webClient = WebClient.create();

    @GetMapping("/")
    @ResponseBody
    public List<OrderDto> getMainPage() {
        ResourceRoot<Order> orders = webClient.get()
                .uri("http://localhost:8081/orders")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResourceRoot<Order>>() {})
                .block();

        ResourceRoot<Price> prices = webClient.get()
                .uri("http://localhost:8082/prices")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResourceRoot<Price>>() {})
                .block();

        List<OrderDto> response = new ArrayList<>();

        if (orders != null) {
            orders.get_embedded().data.forEach(order -> {
                Optional<Price> first = Optional.empty();
                if (prices != null) {
                    first = prices.get_embedded().data.stream()
                            .filter(price -> price.getOrderId().getId().equals(order.getId()))
                            .findFirst();
                }
                first.ifPresent(price -> response.add(OrderDto.builder().withId(order.getId()).withPrice(price.getValue()).build()));
            });
        }

        return response;
    }

}
