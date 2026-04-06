package com.debmalya.financial_data_processing.user;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.debmalya.financial_data_processing.Exceptions.EmailAlreadyExistsException;
import com.debmalya.financial_data_processing.auth.enums.UserStatus;
import com.debmalya.financial_data_processing.user.dtos.RegisterUserRequest;
import com.debmalya.financial_data_processing.user.dtos.UpdateUserRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    public UserRepository userRepository;

    @Transactional
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

    @Transactional
    public User updateUser(UUID userId, UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        //do update operations
        if(updateUserRequest.getEmail()!=null && !updateUserRequest.getEmail().equals(user.getEmail()) ){
            if(userRepository.existsByEmail(updateUserRequest.getEmail())){
                throw new EmailAlreadyExistsException(updateUserRequest.getEmail());
            } 
            user.setEmail(updateUserRequest.getEmail());
        }

        if(updateUserRequest.getPassword()!=null){
            user.setPassword(updateUserRequest.getPassword());
        }

        if (updateUserRequest.getRole() != null) user.setRole(updateUserRequest.getRole());

        if (updateUserRequest.getStatus() != null) user.setStatus(updateUserRequest.getStatus());
        //save user
        userRepository.save(user);
        return user;
    }

    public Page<User> getAllUsers(int page, int size){
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("createdAt").descending()
        );
        return userRepository.findAll(pageable);
    }

}
