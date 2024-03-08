package com.twelve0822.weighing.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.twelve0822.weighing.entities.UserInfo;

@Repository
public interface UserInfoRepository extends ListCrudRepository<UserInfo, Long> {
    Optional<UserInfo> findFirstByOrderByUserIdDesc();
}
