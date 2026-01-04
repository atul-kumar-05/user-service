package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    private Boolean active;
    private Instant createdAt;
    private Instant updatedAt;
}
