package com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto;

import com.myprojects.fooddeliverysystem.CustomerManager.application.api.entity.User;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record UserDto(
    String name,
    String email,
    String phone,
    String pan,
    String address,
    String password
) {

  public static User toUser(UserDto userDto) {
    return User.builder()
        .id("UserID_" + UUID.randomUUID())
        .name(userDto.name)
        .email(userDto.email)
        .phone(userDto.phone)
        .pan(userDto.pan)
        .address(userDto.address)
        .password(userDto.password)
        .createdAt(Instant.now())
        .updatedAt(Instant.now())
        .build();
  }

  public static UserDto fromUser(User user) {
    return UserDto.builder()
        .name(user.name())
        .email(user.email())
        .phone(user.phone())
        .pan(user.pan())
        .address(user.address())
        .password("********")
        .build();
  }
}
