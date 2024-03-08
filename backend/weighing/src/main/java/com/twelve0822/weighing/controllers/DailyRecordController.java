package com.twelve0822.weighing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twelve0822.weighing.models.DailyRecordRequest;
import com.twelve0822.weighing.models.DailyRecordResponse;
import com.twelve0822.weighing.services.RecordService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/api")
public class DailyRecordController {

  @Autowired
  private RecordService recordService;

  @GetMapping("/records")
  @ResponseStatus(value = HttpStatus.OK)
  public List<DailyRecordResponse> getRecords(@RequestParam Long userId) {
    return recordService.getByUserId(userId);
  }

  @PostMapping("/record")
  @ResponseStatus(value = HttpStatus.CREATED)
  public DailyRecordResponse addRecord(@Valid @RequestBody DailyRecordRequest req) {
    return recordService.add(req);
  }

  @PutMapping("/record/{recordId}")
  @ResponseStatus(value = HttpStatus.OK)
  public DailyRecordResponse updateRecord(@PathParam("recordId") Long recordId,
      @Valid @RequestBody DailyRecordRequest req, HttpServletResponse response) {
    return recordService.update(recordId, req);
  }

  @DeleteMapping("/record/{recordId}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteRecord(@PathParam("recordId") Long recordId) {
    recordService.delete(recordId);
  }

}
