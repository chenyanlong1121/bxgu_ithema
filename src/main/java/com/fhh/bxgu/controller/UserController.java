package com.fhh.bxgu.controller;

import com.alibaba.fastjson.JSON;
import com.fhh.bxgu.entity.Userinfo;
import com.fhh.bxgu.service.UserService;
import com.fhh.bxgu.utility.TokenPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //登录。
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private String login(HttpServletRequest request) {
        String username=request.getParameter("username"),
                passwordAfterMd5 = request.getParameter("password"),
                deviceId = request.getParameter("deviceid");
        if(passwordAfterMd5!=null) {
            System.out.println(String.format("username=%s&password=%s", username, passwordAfterMd5));
            if (!userService.checkUserIfExist(username)) {
                return "Not exists";
            }
            if (userService.checkLogin(username, passwordAfterMd5) == 1) {
                userService.insertAutoLogin(username,deviceId);
            }
            else
                return "Fail";
        }
        else {
            if(!(userService.autoLogin(username,deviceId)>0))
                return "Fail";
        }
        //特别地，我们需要在登录时返回Token。
        String ret = JSON.toJSONString(userService.getUserinfo(username));
        System.out.println(ret);
        //Tricky的做法。
        StringBuilder sb = new StringBuilder(ret);
        sb.deleteCharAt(sb.length()-1);
        sb.append(",\"token\":\"");
        sb.append(TokenPool.getToken());
        sb.append("\"}");
        System.out.println(sb.toString());
        return sb.toString();
    }
    //注册。
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    private String register(HttpServletRequest request) {
        String username=request.getParameter("username"),passwordAfterMd5 = request.getParameter("password");
        System.out.println(String.format("username=%s&password=%s",username,passwordAfterMd5));
        if(userService.checkUserIfExist(username)) {
            return "Exists";
        }
        if(userService.register(username,passwordAfterMd5)==1)
            return JSON.toJSONString(userService.getUserinfo(username));
        else
            return "Fail";
    }
    //修改密码。
    @RequestMapping(value = "/change_password",method = RequestMethod.POST)
    private String changePassword(HttpServletRequest request) {
        String username=request.getParameter("username"),origPasswordAfterMd5 = request.getParameter("origpassword"),newPasswordAfterMd5 = request.getParameter("newpassword");
        System.out.println(String.format("username=%s&origpassword=%s&newpassword=%s",username,origPasswordAfterMd5,newPasswordAfterMd5));
        if(!userService.checkUserIfExist(username)) {
            return "Not exists";
        }
        if(userService.changePassword(username,origPasswordAfterMd5,newPasswordAfterMd5)==1)
            return "OK";
        else
            return "Fail";
    }
    @RequestMapping(value = "/reset_password",method = RequestMethod.POST)
    private String resetPassword(HttpServletRequest request) {
        String username=request.getParameter("username"),
                protectAnswer= request.getParameter("answer");
        if(!userService.checkUserIfExist(username)) {
            return "Not exists";
        }
        if(userService.resetPassword(username,protectAnswer)==1)
            return "OK";
        else
            return "Fail";
    }
    //设置密保。
    @RequestMapping(value = "/set_password_protect",method = RequestMethod.POST)
    private String setPasswordProtect(HttpServletRequest request) {
        String username=request.getParameter("username"),
        //        passwordAfterMd5=request.getParameter("password"),
                protectQuesion=request.getParameter("protectquesion"),
                questionAnswerAfterMd5=request.getParameter("questionanswer");
        System.out.println(String.format("username=%s&question=%s&answer=%s",username,protectQuesion,questionAnswerAfterMd5));
        if(!userService.checkUserIfExist(username)) {
            return "Not exists";
        }
        else {
            if(userService.setPasswordProtect(username,protectQuesion,questionAnswerAfterMd5)==1)
                return "OK";
            else
                return "Fail";
        }
    }
    //修改个人信息
    @RequestMapping(value = "/update_userinfo",method = RequestMethod.POST)
    public String updateUserInfo(HttpServletRequest request) {
        String username=request.getParameter("username"),
                nickname = request.getParameter("nickname"),
                sex = request.getParameter("sex"),
                signature = request.getParameter("signature");
        if(!userService.checkUserIfExist(username)) {
            return "Not exists";
        }
        if(userService.updateUserinfo(new Userinfo(username,nickname,sex,signature))==1)
            return "OK";
        else
            return "Fail";
    }
}
