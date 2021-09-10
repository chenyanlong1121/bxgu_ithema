package com.fhh.bxgu.entity;

public class Course {
    private final String imgtitle,title,intro;
    private final long timestamp;
    private final int courseid;
    public Course(String imgtitle, String title, String intro, long timestamp,int courseid) {
        this.imgtitle = imgtitle;
        this.title = title;
        this.intro = intro;
        this.timestamp = timestamp;
        this.courseid = courseid;
    }

    public String getImgtitle() {
        return imgtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public int getCourseid() {
        return courseid;
    }
    @Override
    public String toString() {
        return String.format("(%s/%s:%s at %d)",title,imgtitle,intro,timestamp);
    }
}
