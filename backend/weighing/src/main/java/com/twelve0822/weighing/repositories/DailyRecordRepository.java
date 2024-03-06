package com.twelve0822.weighing.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.twelve0822.weighing.entities.DailyRecord;

@Repository
public interface DailyRecordRepository extends ListCrudRepository<DailyRecord, Long> {
    Optional<DailyRecord> findFirstByUserIdOrderByPostedTimeDesc(Long userId);

    List<DailyRecord> findByUserIdOrderByPostedTimeDesc(Long userId);
}
