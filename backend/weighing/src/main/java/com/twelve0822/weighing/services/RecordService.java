package com.twelve0822.weighing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twelve0822.weighing.repositories.DailyRecordRepository;

@Service
public class RecordService {
    @Autowired
    private DailyRecordRepository dailyRecordRepository;

}
