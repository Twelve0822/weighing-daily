package com.twelve0822.weighing.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(length=100, nullable=false, unique=true)
    private String name;

    @Column(nullable=false)
    private Date birthday;

    @Column(nullable=false)
    private Float initialWeight;

    @Column(nullable=false)
    private Float targetWeight;

    @Column(length=200)
    private String email;

    @Column(nullable=false)
    private Integer initialHeight;
}
