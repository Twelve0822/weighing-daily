package com.twelve0822.weighing.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.twelve0822.weighing.entities.UserInfo;

@RepositoryRestResource
public interface UserInfoRepository extends PagingAndSortingRepository<UserInfo, Long>, CrudRepository<UserInfo,Long> {
}