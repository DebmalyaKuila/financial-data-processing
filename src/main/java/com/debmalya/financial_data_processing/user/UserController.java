package com.debmalya.financial_data_processing.user;

import com.debmalya.financial_data_processing.user.dtos.RegisterUserRequest;
import com.debmalya.financial_data_processing.user.dtos.RegisterUserResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequest registeruserReq){
        User user = userService.registerUser(registeruserReq);
        RegisterUserResponse response = new RegisterUserResponse(user.getId(),user.getEmail(),user.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
