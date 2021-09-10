package com.fhh.bxgu.entity;

public class Video {
    /*
     *     "chapterId": 1,
    "videoId": "1",
    "title": "第1章 Android 基础入门",
    "secondTitle": "Android系统简介",
    "videoPath": "video11.mp4"
     */
    int chapterId,videoId;
    String title,secondTitle,videoPath;

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
