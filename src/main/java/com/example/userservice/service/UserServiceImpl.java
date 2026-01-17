package com.example.userservice.service;

import com.example.userservice.UserStatus;
import com.example.userservice.dto.CreateUserRequest;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.model.UserProfile;
import com.example.userservice.repository.UserProfileRepository;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final UserProfileRepository profileRepo;

    @Override
    public UserResponse createUser(CreateUserRequest req) {

        User user = userRepo.save(
                new User()
        );

        profileRepo.save(
                UserProfile.builder()
                        .user(user)
                        .firstName(req.getFirstName())
                        .lastName(req.getLastName())
                        .build()
        );

        return UserResponse.from(user, req.getFirstName(), req.getLastName());
    }

    @Override
    public UserResponse getUser(UUID userId) {
        User user = userRepo.findByUserIdAndDeleted(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        UserProfile profile = profileRepo.findByUserIdAndDeleted(userId)
                .orElseThrow(() -> new UserNotFoundException("User profile not found"));

        return UserResponse.from(user, profile.getFirstName(), profile.getLastName());
    }

    @Override
    public void blockUser(UUID userId) {
        User user = userRepo.findById(userId).orElseThrow();
        user.setStatus(UserStatus.BLOCKED);
    }
}
