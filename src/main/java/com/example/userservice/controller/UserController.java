package com.example.userservice.controller;

import com.example.userservice.dto.BlockUserReqDto;
import com.example.userservice.dto.CreateUserReqDto;
import com.example.userservice.dto.UserResDto;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
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

    public ResponseEntity<UserResDto> createUser(@RequestBody @Valid CreateUserReqDto createUserReqDto) {
        UserResDto user = userService.createUser(createUserReqDto);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserResDto> getUserByPhone(@PathVariable UUID userId) {
        UserResDto user = userService.getUser(userId);
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<?> blockUser(@RequestBody BlockUserReqDto blockUserReqDto) {
        userService.blockUser(blockUserReqDto);
        return ResponseEntity.noContent().build();
    }
}
