package com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto;

import lombok.Builder;

@Builder
public record UserConfigResponse(
    String status,
    int statusCode,
    String message,
    UserDto userDetails
) {
}
