package com.example.userservice.model;

import com.example.userservice.UserStatus;
import com.example.userservice.util.UserType;
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
        @Column(name = "user_id", unique = true, nullable = false)
        private UUID userId;

        @Column(unique = true)
        private String phone;

        @Column(unique = true)
        private String email;

        @Column(name = "status")
        private UserStatus status;

        @Column(name = "user_type")
        private UserType userType;

        @Column(name = "email_verified")
        private Boolean emailVerified;

        @Column(name = "phone_verified")
        private Boolean phoneVerified;

        @OneToOne(mappedBy = "user_profile", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private UserProfile userProfile;

        @OneToOne(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        private Address address;
}
