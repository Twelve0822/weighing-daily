package com.twelve0822.weighing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twelve0822.weighing.models.AddUserRequest;
import com.twelve0822.weighing.models.AddUserResponse;
import com.twelve0822.weighing.models.GetUserResponse;
import com.twelve0822.weighing.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api")
public class UserInfoController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public GetUserResponse getUser() {
    return userService.getUser();
  }

  @PostMapping("/user")
  public ResponseEntity<AddUserResponse> addUser(@Valid @RequestBody AddUserRequest req) {
    AddUserResponse res = userService.addUser(req);
    if (res.getUserExisted()) {
      return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }
    return ResponseEntity.ok(res);
  }
}
