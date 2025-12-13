package com.example.unitedportraits.order;

import com.example.unitedportraits.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    //hello world
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(nullable = false, length = 20)
    private String status; // "pending" or "paid"

    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    @PrePersist
    public void onCreate() {
        if (creationDateTime == null) {
            creationDateTime = LocalDateTime.now();
        }
    }
}
