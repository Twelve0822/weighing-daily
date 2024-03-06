package com.twelve0822.weighing.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.twelve0822.weighing.entities.DailyRecord;
import com.twelve0822.weighing.models.DailyRecordRequest;
import com.twelve0822.weighing.models.DailyRecordResponse;
import com.twelve0822.weighing.repositories.DailyRecordRepository;

@Service
public class RecordService {

    @Autowired
    private DailyRecordRepository dailyRecordRepository;

    public List<DailyRecordResponse> getByUserId(Long userId) {
        List<DailyRecord> dailyRecords = dailyRecordRepository.findByUserIdOrderByPostedTimeDesc(userId);
        return dailyRecords.stream().map(record -> {
            DailyRecordResponse res = new DailyRecordResponse();
            BeanUtils.copyProperties(record, res);
            return res;
        }).collect(Collectors.toList());
    }

    public DailyRecordResponse add(DailyRecordRequest req) {
        DailyRecordResponse res = new DailyRecordResponse();
        DailyRecord dailyRecord = new DailyRecord();
        BeanUtils.copyProperties(req, dailyRecord);
        dailyRecord = dailyRecordRepository.save(dailyRecord);
        BeanUtils.copyProperties(dailyRecord, res);
        return res;
    }

    public DailyRecordResponse update(Long recordId, DailyRecordRequest req) {
        if (!dailyRecordRepository.findById(recordId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        DailyRecordResponse res = new DailyRecordResponse();
        DailyRecord dailyRecord = new DailyRecord();
        BeanUtils.copyProperties(req, dailyRecord);
        dailyRecord.setRecordId(recordId);
        dailyRecord = dailyRecordRepository.save(dailyRecord);
        BeanUtils.copyProperties(dailyRecord, res);
        return res;
    }

    public void delete(Long recordId) {
        dailyRecordRepository.deleteById(recordId);
    }

}
