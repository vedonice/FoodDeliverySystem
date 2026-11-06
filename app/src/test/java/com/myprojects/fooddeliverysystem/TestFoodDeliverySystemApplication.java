package com.myprojects.fooddeliverysystem;

import org.springframework.boot.SpringApplication;

public class TestFoodDeliverySystemApplication {

  public static void main(String[] args) {
    SpringApplication.from(FoodDeliverySystemApplication::main).with(TestcontainersConfiguration.class).run(args);
  }

}
