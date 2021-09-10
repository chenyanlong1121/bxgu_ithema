package com.fhh.bxgu.service;

import com.fhh.bxgu.entity.Userinfo;
import com.fhh.bxgu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public int checkLogin(String username,String passwordAfterMd5) {
        return userMapper.checkLogin(username,passwordAfterMd5);
    }
    public int register(String username,String passwordAfterMd5) {
        return userMapper.register(username,passwordAfterMd5);
    }
    public Userinfo getUserinfo(String username) {
        return userMapper.getUserInfo(username);
    }
    public int changePassword(String username,String origPasswordAfterMd5,String newPasswordAfterMd5) {
        return userMapper.changePassword(username, origPasswordAfterMd5, newPasswordAfterMd5);
    }
    public boolean checkUserIfExist(String username) {
        return userMapper.checkUserIfExist(username)==1;
    }
    public int setPasswordProtect(String username,String question,String answerAfterMd5) {
        return userMapper.setPasswordProtect(username, question, answerAfterMd5);
    }
    public int updateUserinfo(Userinfo userinfo) {
        return userMapper.updateUserInfo(userinfo);
    }
    public int resetPassword(String username,String answer) {
        return userMapper.resetPassword(username,answer);
    }
    public int autoLogin(String username,String deviceid) {
        return userMapper.autoLogin(username, deviceid);
    }
    public int insertAutoLogin(String username,String deviceid) {
        return userMapper.insertAutoLogin(username, deviceid);
    }
}
