package com.example.unitedportraits.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateOrderRequest(
        @NotNull Long studentId,
        @NotNull @Min(0) BigDecimal total,
        @NotNull String status
) {
}
