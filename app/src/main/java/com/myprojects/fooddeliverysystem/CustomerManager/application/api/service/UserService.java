package com.myprojects.fooddeliverysystem.CustomerManager.application.api.service;

import com.myprojects.fooddeliverysystem.CustomerManager.application.api.dto.UserDto;
import com.myprojects.fooddeliverysystem.CustomerManager.application.api.exception.ResourceAlreadyExistException;
import com.myprojects.fooddeliverysystem.CustomerManager.application.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  @Autowired
  private final UserRepository userRepository;

  public UserDto createUser(UserDto userDto) {
    var userEntity = userRepository.findByPan(userDto.pan());
    if (userEntity.isPresent()) {
      throw new ResourceAlreadyExistException("User already exists");
    }

    var user = UserDto.toUser(userDto);
    userRepository.save(user);

    return UserDto.fromUser(user);
  }
}
