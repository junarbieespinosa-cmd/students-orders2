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
        //this is a data transfer object for student 3333
        return new StudentDto(
                s.getStudentId(),
                s.getName(),
                s.getGrade(),
                s.getSchool(),
                s.getCreationDateTime()
        );
    }
}
