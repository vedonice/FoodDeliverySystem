package com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto;

import lombok.Builder;

@Builder
public record UserConfigRequest(
    String name,
    String email,
    String phone,
    String pan,
    String address,
    String password
) {}
