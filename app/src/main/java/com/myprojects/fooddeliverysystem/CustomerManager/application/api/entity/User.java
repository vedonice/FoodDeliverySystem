package com.myprojects.fooddeliverysystem.CustomerManager.application.api.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Builder
@Document( collection = "fds-users")
public record User(
    @Id String id,
    String name,
    String email,
    String phone,
    String pan,
    String address,
    String password,
    Instant createdAt,
    Instant updatedAt
) {
}
