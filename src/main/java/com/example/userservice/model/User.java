package com.example.userservice.model;

import com.example.userservice.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private UUID userId;

        @Column(unique = true)
        private String phone;

        @Column(unique = true)
        private String email;

        @Column(name = "status")
        private UserStatus status;
}
