package com.twelve0822.weighing.models;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddUserRequest {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    private Date birthday;

    @Size(max = 200)
    private String email;

    @NotBlank
    @Min(1)
    @Max(300)
    private Integer initialHeight;

    @NotBlank
    @Min(1)
    @Max(600)
    private Float initialWeight;

    @NotBlank
    @Min(1)
    @Max(600)
    private Float targetWeight;
}
