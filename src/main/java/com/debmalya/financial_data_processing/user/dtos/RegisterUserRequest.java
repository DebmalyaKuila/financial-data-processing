package com.debmalya.financial_data_processing.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.debmalya.financial_data_processing.auth.enums.Role;

import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 4)
    private String password;
    private Role role; // By default give the least privilege role
}
