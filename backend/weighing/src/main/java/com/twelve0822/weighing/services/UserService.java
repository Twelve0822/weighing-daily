package com.twelve0822.weighing.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twelve0822.weighing.models.FirstUserResponse;
import com.twelve0822.weighing.repositories.UserInfoRepository;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public static List<FirstUserResponse> firstUserResponseList = new ArrayList<>();
    public FirstUserResponse getFirstUser(){
        //to do
        FirstUserResponse firstUser = new FirstUserResponse();
        firstUser.setUserExisted(true);

        FirstUserResponse firstUserResponse = firstUserResponseList.get(0);
        return firstUserResponse;
    }

    public FirstUserResponse addUser(FirstUserResponse firstUserResponse){
        firstUserResponseList.add(firstUserResponse);
        return firstUserResponse;
    }
}
