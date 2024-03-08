package com.twelve0822.weighing.models;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DailyRecordRequest {
    @NotNull
    private Long userId;

    private Date postedTime;

    @NotNull
    @Min(1)
    @Max(600)
    private Float dailyWeight;

    @Size(max = 1000)
    private String comment;

    @Size(max = 200)
    private String photoUrl;
}
