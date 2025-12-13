package com.example.unitedportraits.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDto(
        Long orderId,
        Long studentId,
        BigDecimal total,
        String status,
        LocalDateTime creationDateTime
) {
    public static OrderDto fromEntity(Order o) {
        return new OrderDto(
                o.getOrderId(),
                o.getStudent().getStudentId(),
                o.getTotal(),
                o.getStatus(),
                o.getCreationDateTime()
        );
    }
}
