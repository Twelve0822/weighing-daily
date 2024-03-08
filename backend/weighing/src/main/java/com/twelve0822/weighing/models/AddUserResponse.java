package com.twelve0822.weighing.models;

import java.util.Date;

import lombok.Data;

@Data
public class AddUserResponse {
    private Boolean userExisted;
    private Long userId;
    private String name;
    private Date birthday;
    private String email;
    private Integer initialHeight;
    private Float initialWeight;
    private Float targetWeight;
}
