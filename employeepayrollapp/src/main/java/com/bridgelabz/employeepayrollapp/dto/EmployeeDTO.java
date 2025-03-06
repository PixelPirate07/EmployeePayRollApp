package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotNull(message="salary cannot be empty")
    private Integer salary;
}
