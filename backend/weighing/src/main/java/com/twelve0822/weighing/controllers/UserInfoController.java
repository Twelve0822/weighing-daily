package com.twelve0822.weighing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twelve0822.weighing.models.FirstUserResponse;
import com.twelve0822.weighing.services.UserService;

@RestController
@RequestMapping(path="/api") 
public class UserInfoController {
    @Autowired
   private UserService userService;

    @GetMapping("/first-user")
  public FirstUserResponse getFirstUser() {
    return userService.getFirstUser();
  }

    @PostMapping("/user")
  public FirstUserResponse addUser(@RequestBody FirstUserResponse firstUserResponse) {
      return userService.addUser(firstUserResponse);
    }
  }
