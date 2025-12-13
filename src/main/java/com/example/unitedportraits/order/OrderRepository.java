package com.example.unitedportraits.order;

import com.example.unitedportraits.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStudent(Student student);
}
