package com.debmalya.financial_data_processing.user.dtos;

import com.debmalya.financial_data_processing.auth.enums.Role;
import com.debmalya.financial_data_processing.auth.enums.UserStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdateUserRequest {

    @Email
    private String email;

    @Size(min = 4)
    private String password;

    private Role role;

    private UserStatus status;

}
