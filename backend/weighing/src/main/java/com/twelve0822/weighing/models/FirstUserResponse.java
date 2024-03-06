package com.twelve0822.weighing.models;

import lombok.Data;

@Data
public class FirstUserResponse {
    private Boolean userExisted;
    
    private Long userId;
    private String name;
    private Float initialWeight;
    private Float targetlWeight;
    private Float lastWeight;
    private String email;
    private String birthday;
}
