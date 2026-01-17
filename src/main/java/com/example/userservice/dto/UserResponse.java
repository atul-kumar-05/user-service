package com.example.userservice.dto;

import com.example.userservice.UserStatus;
import com.example.userservice.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserStatus userStatus;

    public static UserResponse from(User user, @NotBlank(message = "First name is required") String firstName, @NotBlank(message = "Last name is required") String lastName) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .firstName(firstName)
                .lastName(lastName)
                .email(user.getEmail())
                .phoneNumber(user.getPhone())
                .userStatus(user.getStatus())
                .build();
    }
}
