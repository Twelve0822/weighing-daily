package com.twelve0822.weighing.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twelve0822.weighing.entities.DailyRecord;
import com.twelve0822.weighing.entities.UserInfo;
import com.twelve0822.weighing.models.AddUserRequest;
import com.twelve0822.weighing.models.AddUserResponse;
import com.twelve0822.weighing.models.GetUserResponse;
import com.twelve0822.weighing.repositories.DailyRecordRepository;
import com.twelve0822.weighing.repositories.UserInfoRepository;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private DailyRecordRepository dailyRecordRepository;

    public GetUserResponse getUser() {
        GetUserResponse res = new GetUserResponse();
        Optional<UserInfo> userInfo = userInfoRepository.findFirstByOrderByUserIdDesc();
        if (!userInfo.isPresent()) {
            res.setUserExisted(false);
            return res;
        }

        BeanUtils.copyProperties(userInfo.get(), res);
        res.setUserExisted(true);
        res.setLastWeight(dailyRecordRepository.findFirstByUserIdOrderByPostedTimeDesc(userInfo.get().getUserId())
                .map(DailyRecord::getDailyWeight).orElse(null));
        return res;
    }

    public AddUserResponse addUser(AddUserRequest req) {
        AddUserResponse res = new AddUserResponse();
        Optional<UserInfo> userInfo = userInfoRepository.findFirstByOrderByUserIdDesc();
        if (userInfo.isPresent()) {
            BeanUtils.copyProperties(userInfo.get(), res);
            res.setUserExisted(true);
            return res;
        }
        UserInfo newUserInfo = new UserInfo();
        BeanUtils.copyProperties(req, newUserInfo);
        newUserInfo = userInfoRepository.save(newUserInfo);
        BeanUtils.copyProperties(newUserInfo, res);
        res.setUserExisted(false);
        return res;
    }

}
