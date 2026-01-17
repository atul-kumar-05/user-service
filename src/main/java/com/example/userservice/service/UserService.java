package com.example.userservice.service;

import com.example.userservice.dto.CreateUserRequest;
import com.example.userservice.dto.UpdateUserReqDto;
import com.example.userservice.dto.UserResponse;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public interface UserService {

    public UserResponse createUser(CreateUserRequest user);

    public UserResponse getUser(UUID id);

    public void blockUser(UUID id);

}
