package com.twelve0822.weighing.models;

import java.util.Date;

import lombok.Data;

@Data
public class DailyRecordResponse {
    private Long recordId;
    private Long userId;
    private Date postedTime;
    private Float dailyWeight;
    private String comment;
    private String photoUrl;
}
