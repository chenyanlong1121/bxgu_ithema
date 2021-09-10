package com.fhh.bxgu.service;

import com.fhh.bxgu.entity.Chapter;
import com.fhh.bxgu.entity.Question;
import com.fhh.bxgu.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    public List<Question> parseQuestions(File file,int chapter) {
        List<Question> questions = new ArrayList<>();
        //1.创建DocumentBuilderFactory对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.创建DocumentBuilder对象
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document d = builder.parse(file);
            Node node = d.getElementsByTagName("infos").item(0);
            NodeList questionNodes = node.getChildNodes(); //<exercises>s
            node = questionNodes.item(0).getNextSibling();
            for(int i=1;i<=questionNodes.getLength();i++) {
                Question question = new Question();
                question.setChapter(chapter);
                question.setId(i);
                Node innerNode = node.getFirstChild();
                while(innerNode != null) {
                    while(innerNode.getNodeName().equals("#text"))
                        innerNode = innerNode.getNextSibling();
                    switch (innerNode.getNodeName().charAt(0)) {
                        case 'a':{
                            if(innerNode.getNodeName().length()==1) {
                                question.setA(innerNode.getTextContent());
                            }
                            else {
                                question.setAnswer(Integer.parseInt(innerNode.getTextContent()));
                            }
                            break;
                        }
                        case 'b':{question.setB(innerNode.getTextContent());break;}
                        case 'c':{question.setC(innerNode.getTextContent());break;}
                        case 'd':{question.setD(innerNode.getTextContent());break;}
                        case 's':{question.setDesc(innerNode.getTextContent().substring(2));break;}
                    }
                    innerNode = innerNode.getNextSibling().getNextSibling();
                }
                questions.add(question);
                node = node.getNextSibling().getNextSibling();
                if(node==null)
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
    public void insertQuestion(List<Question> questions, String language) {
        switch (language) {
            case "zh_CN":{
                questionMapper.addExerciseZhCn(questions);
                return;}
            case "en_US":{
                questionMapper.addExerciseEnUs(questions);
            }
        }
    }
    public List<Question> getQuestionByChapterId(int chapterId,String lang) {
        switch (lang) {
            case "zh_CN":{
                return questionMapper.getQuestionByChapterIdZhCn(chapterId);
            }
            case "en_US":{
                return questionMapper.getQuestionByChapterIdEnUs(chapterId);
            }
        }
        return null;
    }
    public List<Chapter> getQuestionChapterList(String lang) {
        switch (lang) {
            case "zh_CN":{
                return questionMapper.getQuestionChapterListZhCn();
            }
            case "en_US":{
                return questionMapper.getQuestionChapterListEnUs();
            }
        }
        return null;
    }
}
