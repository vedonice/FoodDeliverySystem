package com.myprojects.fooddeliverysystem.CustomerManager.application.api.controller;

import com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto.UserConfigRequest;
import com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto.UserConfigResponse;
import com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto.UserDto;
import com.myprojects.fooddeliverysystem.CustomerManager.application.api.exception.ResourceAlreadyExistException;
import com.myprojects.fooddeliverysystem.CustomerManager.application.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/fooddeliverysystem/user")
public class UserController {

  @Autowired
  private final UserService userService;

  @PostMapping("/config")
  public ResponseEntity<UserConfigResponse> createUser(@RequestBody UserConfigRequest userConfigRequest) {
    UserConfigResponse userConfigResponse = null;

    try{
      var userDto = mapToUserDto(userConfigRequest);

      UserDto createdUser = userService.createUser(userDto);

      userConfigResponse = UserConfigResponse.builder()
          .status("Success")
          .statusCode(201)
          .message("User created successfully")
          .userDetails(createdUser)
          .build();
    } catch (ResourceAlreadyExistException e) {
      userConfigResponse = UserConfigResponse.builder()
          .status("Failed")
          .statusCode(400)
          .message(e.getMessage())
          .build();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userConfigResponse);
    } catch (Exception e) {
      userConfigResponse = UserConfigResponse.builder()
          .status("Failed")
          .statusCode(500)
          .message(e.getMessage())
          .build();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userConfigResponse);
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(userConfigResponse);
  }

  private UserDto mapToUserDto(UserConfigRequest userConfigRequest) {
    return UserDto.builder()
        .name(userConfigRequest.name())
        .email(userConfigRequest.email())
        .phone(userConfigRequest.phone())
        .pan(userConfigRequest.pan())
        .address(userConfigRequest.address())
        .password(userConfigRequest.password())
        .build();
  }
}
