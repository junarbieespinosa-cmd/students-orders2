package com.example.unitedportraits.student;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDto::fromEntity)
                .toList();
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student s = new Student();
        s.setName(request.name());
        s.setGrade(request.grade());
        s.setSchool(request.school());

        Student saved = studentRepository.save(s);
        return ResponseEntity.ok(StudentDto.fromEntity(saved));
    }
}
