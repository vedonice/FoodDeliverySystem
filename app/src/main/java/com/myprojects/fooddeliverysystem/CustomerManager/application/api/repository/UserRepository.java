package com.myprojects.fooddeliverysystem.CustomerManager.application.api.repository;

import com.myprojects.fooddeliverysystem.CustomerManager.application.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
  Optional<User> findByPan(String pan);
}
