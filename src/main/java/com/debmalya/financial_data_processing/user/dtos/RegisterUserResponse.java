package com.debmalya.financial_data_processing.user.dtos;

import java.util.UUID;

import com.debmalya.financial_data_processing.auth.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterUserResponse {
    private UUID id;
    private String email;
    private Role role;
}
