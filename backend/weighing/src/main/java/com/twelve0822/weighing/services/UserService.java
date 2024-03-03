package com.twelve0822.weighing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twelve0822.weighing.models.FirstUserResponse;
import com.twelve0822.weighing.repositories.UserInfoRepository;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public FirstUserResponse getFirstUser(){
        //to do
        FirstUserResponse firstUser = new FirstUserResponse();
        firstUser.setUserExisted(true);
        
        return firstUser;
    }
}
