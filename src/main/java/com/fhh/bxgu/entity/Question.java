package com.fhh.bxgu.entity;

public class Question {
    private int chapter,id,answer;
    private String desc,a,b,c,d;

    public int getChapter() {
        return chapter;
    }

    public int getId() {
        return id;
    }

    public int getAnswer() {
        return answer;
    }

    public String getDesc() {
        return desc;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return String.format("%d:%s<br>A:%s<br>B:%s<br>C:%s<br>D:%s<br>Answer:%c<br>",id,desc,a,b,c,d,(char)(answer+64));
    }
}
