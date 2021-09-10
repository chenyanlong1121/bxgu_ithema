package com.fhh.bxgu.entity;

public class History {
    private String time; //时间
    private String userName; //用户名
    private int videoId;//视频id
    private String videoSecondTitle=null; //视频名称
    private String videoTitle=null;//章节名称
    public String getTime() {
        return time;
    }

    public String getVideoSecondTitle() {
        return videoSecondTitle;
    }

    public void setVideoSecondTitle(String videoSecondTitle) {
        this.videoSecondTitle = videoSecondTitle;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public History(String time, String userName, int videoId) {
        this.time = time;
        this.userName = userName;
        this.videoId = videoId;
    }
}
