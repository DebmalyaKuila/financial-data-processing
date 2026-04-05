package com.debmalya.financial_data_processing.user;

import com.debmalya.financial_data_processing.auth.enums.Role;
import com.debmalya.financial_data_processing.auth.enums.UserStatus;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users",
    indexes = {
        @Index(name = "idx_user_email", columnList = "email")
    }
)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Setter
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Setter
    private Role role=Role.VIEWER; // By default give the least privilege role

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Setter
    private UserStatus status=UserStatus.INACTIVE; // inactivate a user privilege by default

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;
}
