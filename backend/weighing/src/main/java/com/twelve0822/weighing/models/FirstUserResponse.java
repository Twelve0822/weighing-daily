package com.twelve0822.weighing.models;

import lombok.Data;

@Data
public class FirstUserResponse {
    private Boolean userExisted;
    
    private Long userId;
    private String name;
    private Float lastWeight;
}
