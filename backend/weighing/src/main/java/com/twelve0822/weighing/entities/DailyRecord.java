package com.twelve0822.weighing.entities;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DailyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    @Column(nullable=false)
    private Long userId;

    @Column(length=100, nullable=false, unique=true)
    private Timestamp postedTime;

    @Column(nullable=false)
    private Float dailyWeight;

    @Column(length=1000, nullable=false)
    private String comment;

    @Column(length=200)
    private String photoUrl;
}

