package com.example.unitedportraits.student;

import com.example.unitedportraits.order.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    //this is the
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    private String name;

    private String grade;

    private String school;

    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @PrePersist
    public void onCreate() {
        if (creationDateTime == null) {
            creationDateTime = LocalDateTime.now();
        }
    }
}
