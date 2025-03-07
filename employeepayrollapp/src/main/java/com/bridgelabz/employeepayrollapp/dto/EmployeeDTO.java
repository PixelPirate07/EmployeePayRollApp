package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message="Name must start with Capital Letter")
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotNull(message="salary cannot be empty")
    private Integer salary;
}
