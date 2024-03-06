package com.twelve0822.weighing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twelve0822.weighing.models.DailyRecordResponse;
import com.twelve0822.weighing.models.FirstUserResponse;
import com.twelve0822.weighing.services.RecordService;


import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/api")
public class DailyRecordController {
  @Autowired
  private RecordService recordService;

  @PostMapping("/record")
  public DailyRecordResponse addRecord(@RequestBody DailyRecordResponse dailyRecord) {
    return recordService.addRecord(dailyRecord);
  }

  @GetMapping("/record/{recordId}")
  public DailyRecordResponse getRecord(@PathParam("recordId") Long recordId) {
    return recordService.getRecord(recordId);
  }

  @PutMapping("/record/{recordId}")
  public DailyRecordResponse updateRecord(@PathParam("recordId") Long recordId,@RequestBody DailyRecordResponse dailyRecord) {
    return recordService.updateRecord(recordId);
  }

  @DeleteMapping("/record/{recordId}")
  public DailyRecordResponse deleteRecord(@PathParam("recordId") Long recordId) {
    return recordService.deleteRecord(recordId);
  }

}
