package com.example.userservice.controller;

import com.example.userservice.dto.CreateUserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;

    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserReqDto) {
        UserResponse user = userService.createUser(createUserReqDto);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserResponse> getUserByPhone(@PathVariable UUID userId) {
        UserResponse user = userService.getUser(userId);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<?> blockUser(@PathVariable UUID userId) {
        userService.blockUser(userId);
        return ResponseEntity.noContent().build();
    }
}
