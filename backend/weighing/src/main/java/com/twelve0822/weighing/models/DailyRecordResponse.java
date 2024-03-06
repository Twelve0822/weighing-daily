package com.twelve0822.weighing.models;

import java.security.Timestamp;

import lombok.Data;

@Data
public class DailyRecordResponse {

    private Long recordId;
    private Long userId;
    private Timestamp postedTime;
    private Float dailyWeight;
    private String comment;
    private String photoUrl;

}
