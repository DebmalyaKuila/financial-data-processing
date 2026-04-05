package com.debmalya.financial_data_processing.user;

import org.springframework.stereotype.Service;

import com.debmalya.financial_data_processing.Exceptions.EmailAlreadyExistsException;
import com.debmalya.financial_data_processing.auth.enums.UserStatus;
import com.debmalya.financial_data_processing.user.dtos.RegisterUserRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    public UserRepository userRepository;

    public User registerUser(RegisterUserRequest registeruserReq){
        if(userRepository.existsByEmail(registeruserReq.getEmail())){
            throw new EmailAlreadyExistsException(registeruserReq.getEmail());
        }

        User user = new User();
        user.setEmail(registeruserReq.getEmail());
        user.setRole(registeruserReq.getRole());
        user.setStatus(UserStatus.ACTIVE);
        user.setPassword(registeruserReq.getPassword());

        userRepository.save(user);
        return user;
    }
}
