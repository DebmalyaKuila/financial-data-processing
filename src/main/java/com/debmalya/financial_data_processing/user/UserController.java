package com.debmalya.financial_data_processing.user;

import com.debmalya.financial_data_processing.user.dtos.RegisterUserRequest;
import com.debmalya.financial_data_processing.user.dtos.RegisterUserResponse;
import com.debmalya.financial_data_processing.user.dtos.UpdateUserRequest;
import com.debmalya.financial_data_processing.user.dtos.UpdateUserResponse;
import com.debmalya.financial_data_processing.user.dtos.UserResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequest registerUserReq){
        User user = userService.registerUser(registerUserReq);
        RegisterUserResponse response = new RegisterUserResponse(user.getId(),user.getEmail(),user.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @Valid @RequestBody UpdateUserRequest updateUserReq){
        User updatedUser = userService.updateUser(id, updateUserReq);
        UpdateUserResponse response = new UpdateUserResponse(
            id,
            updatedUser.getEmail(),
            updatedUser.getRole(),
            updatedUser.getStatus()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){
        Page<User> users = userService.getAllUsers(page, size);
        Page<UserResponse> response = users.map( user ->
            new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                user.getStatus()
            )
        );
        return ResponseEntity.ok(response);
    }
    


}
