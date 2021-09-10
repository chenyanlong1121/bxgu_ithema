package com.fhh.bxgu.entity;

public class Userinfo {

    private String username,nickname,sex,signature;

    public Userinfo() {
    }

    public Userinfo(String username, String nickname, String sex, String signature) {
        this.username = username;
        this.nickname = nickname;
        this.sex = sex;
        this.signature = signature;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }


}
