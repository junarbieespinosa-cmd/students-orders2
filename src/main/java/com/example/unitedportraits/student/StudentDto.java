package com.example.unitedportraits.student;

import java.time.LocalDateTime;

public record StudentDto(
        Long studentId,
        String name,
        String grade,
        String school,
        LocalDateTime creationDateTime
) {
    public static StudentDto fromEntity(Student s) {
        return new StudentDto(
                s.getStudentId(),
                s.getName(),
                s.getGrade(),
                s.getSchool(),
                s.getCreationDateTime()
        );
    }
}
