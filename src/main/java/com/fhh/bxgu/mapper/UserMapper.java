package com.fhh.bxgu.mapper;

import com.fhh.bxgu.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int checkLogin(@Param("username") String username,
                   @Param("password") String password);
    Userinfo getUserInfo(@Param("username") String username);
    int updateUserInfo(@Param("userinfo") Userinfo userinfo);
    int checkUserIfExist(@Param("username") String username);
    int register(@Param("username") String username,
                 @Param("password") String password);
    int changePassword(@Param("username") String username,
                       @Param("origpassword") String origPassword,
                       @Param("newpassword") String newPassword);
    int setPasswordProtect(@Param("username") String username,
                           @Param("question") String question,
                           @Param("answer") String answer);
    int resetPassword(@Param("username") String username,
                      @Param("answer") String answer);
    int autoLogin(@Param("username") String username,
                  @Param("deviceid") String deviceid);
    int insertAutoLogin(@Param("username") String username,
                  @Param("deviceid") String deviceid);
}
