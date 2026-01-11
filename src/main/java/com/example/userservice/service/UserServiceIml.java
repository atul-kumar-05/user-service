package com.example.userservice.service;

import com.example.userservice.dto.CreateUserReqDto;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceIml implements UserService {

    private final UserRepository userRepository;
    @Override
    public User createUser(CreateUserReqDto createUserReqDto) {
        User user = userRepository.save(User.builder())
                .firstName(createUserReqDto.getFirstName())
                .lastName(createUserReqDto.getLastName())
                .phoneNumber(createUserReqDto.getPhoneNumber())
                .isBlocked(false)
                .build());
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public User blockUser(long id) {
        return null;
    }
}
