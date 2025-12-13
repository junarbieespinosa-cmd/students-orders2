package com.example.unitedportraits.order;

import com.example.unitedportraits.student.Student;
import com.example.unitedportraits.student.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderRepository orderRepository;
    private final StudentRepository studentRepository;

    public OrderController(OrderRepository orderRepository,
                           StudentRepository studentRepository) {
        this.orderRepository = orderRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrdersByStudent(@RequestParam("studentId") Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found"));

        List<OrderDto> result = orderRepository.findByStudent(student)
                .stream()
                .map(OrderDto::fromEntity)
                .toList();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        Student student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        Order order = new Order();
        order.setStudent(student);
        order.setTotal(request.total());
        order.setStatus(request.status());

        Order saved = orderRepository.save(order);
        return ResponseEntity.ok(OrderDto.fromEntity(saved));
    }
}
