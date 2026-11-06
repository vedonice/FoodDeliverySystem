package com.myprojects.fooddeliverysystem.CustomerManager.application.api.exception;

public class ResourceAlreadyExistException extends RuntimeException {
  public ResourceAlreadyExistException(String message) {
    super(message);
  }

  public ResourceAlreadyExistException(String message, Throwable cause) {
    super(message, cause);
  }
}
