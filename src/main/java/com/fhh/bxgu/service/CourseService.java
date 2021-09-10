package com.fhh.bxgu.service;

import com.fhh.bxgu.entity.Course;
import com.fhh.bxgu.entity.History;
import com.fhh.bxgu.entity.Question;
import com.fhh.bxgu.entity.Video;
import com.fhh.bxgu.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public List<Course> parseCourses(File file) {
        List<Course> courses = new ArrayList<>();
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse(file);
            Node node = d.getElementsByTagName("infos").item(0);
            NodeList questionNodes = node.getChildNodes(); //<course>s
            node = questionNodes.item(0).getNextSibling();
            for(int i=1;i<=questionNodes.getLength();i++) {
                Node innerNode = node.getFirstChild();
                String imgtitle="",title="",intro="";
                while(innerNode != null) {
                    while(innerNode.getNodeName().equals("#text"))
                        innerNode = innerNode.getNextSibling();
                    switch (innerNode.getNodeName().charAt(1)) {
                        case 'm':{imgtitle = innerNode.getTextContent();break;                     }
                        case 'i':{title = innerNode.getTextContent();break;}
                        case 'n':{intro = innerNode.getTextContent();break;}
                    }
                    innerNode = innerNode.getNextSibling().getNextSibling();
                    if(innerNode==null)
                        break;
                }
                    courses.add(new Course(imgtitle,title,intro,0,0));
                    node = node.getNextSibling().getNextSibling();

                }
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
    public void insertCourses(List<Course> courses,String lang) {
        if(lang.equals("en_US")) {
            courseMapper.insertCourseInfoEnUs(courses);
        }
        else {
            courseMapper.insertCourseInfoZhCn(courses);
        }
    }
    public List<Course> getCourseInfo(String lang) {
        if(lang.equals("zh_CN")) {
            return courseMapper.getCourseInfoZhCn();
        }
        else {
            return courseMapper.getCourseInfoEnUs();
        }
    }
    public List<Course> getCourseInfoById(String lang,int courseId) {
        if(lang.equals("zh_CN")) {
            return courseMapper.getCourseInfoZhCnById(courseId);
        }
        else {
            return courseMapper.getCourseInfoEnUsById(courseId);
        }
    }
    public List<Video> getVideoData(String lang) {
        if(lang.equals("zh_CN")) {
            return courseMapper.getVideoInfoZhCn();
        }
        else {
            return courseMapper.getVideoInfoEnUs();
        }
    }
    public List<History> getHistory(String username) {
        return courseMapper.getHistory(username);
    }
    public void insertHistory(int courseId,String username) {
        courseMapper.insertHistory(courseId,username);
    }
}
