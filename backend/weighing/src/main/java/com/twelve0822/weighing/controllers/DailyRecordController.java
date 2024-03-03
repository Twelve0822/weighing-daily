package com.twelve0822.weighing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twelve0822.weighing.models.FirstUserResponse;
import com.twelve0822.weighing.services.RecordService;

@RestController
@RequestMapping(path="/api") 
public class DailyRecordController {
    @Autowired
   private RecordService recordService;

    @PostMapping("/")
  public FirstUserResponse getFirstUser() {
    return userService.getFirstUser();
  }
}
