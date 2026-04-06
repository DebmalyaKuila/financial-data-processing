package com.debmalya.financial_data_processing.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
import com.debmalya.financial_data_processing.auth.enums.Role;
import com.debmalya.financial_data_processing.auth.enums.UserStatus;

@Getter
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String email;
    private Role role;
    private UserStatus status;
}