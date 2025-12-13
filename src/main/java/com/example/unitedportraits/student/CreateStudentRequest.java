package com.example.unitedportraits.student;

import jakarta.validation.constraints.NotBlank;

public record CreateStudentRequest(
        @NotBlank String name,
        @NotBlank String grade,
        @NotBlank String school
) {
}
