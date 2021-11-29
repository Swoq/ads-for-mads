package com.swoqe.adsformads.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private UUID id;
    private BigDecimal price;
    private UUID customerId;
}
