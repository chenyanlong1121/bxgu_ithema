package com.fhh.bxgu.controller;


import com.fhh.bxgu.entity.Chapter;
import com.fhh.bxgu.entity.Question;
import com.fhh.bxgu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @ResponseBody
    @PostMapping(value = "upload_question")
    public String uploadQuestionPost(@RequestParam("file") MultipartFile file,@RequestParam("chapter") int chapter,@RequestParam("lang") String lang) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        };
        String fileName = file.getOriginalFilename();

        try {
            String filePath = ResourceUtils.getURL("classpath:").getPath();
            File dest = new File(filePath + "upload/"+fileName);
            file.transferTo(dest);
            List<Question> questions = questionService.parseQuestions(dest,chapter);
            questionService.insertQuestion(questions,lang);
            StringBuilder result= new StringBuilder();
            for(Question i :questions) {
                result.append(i);
            }
            result.append(lang);
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";

    }
    @RequestMapping(value = "upload_question",method = RequestMethod.GET)
    public String uploadQuestion() {
        return "upload_question";
    }
    @ResponseBody
    @RequestMapping("load_question")
    public List<Question> getQuestionByChapterId(HttpServletRequest request) {
        int chapter = Integer.parseInt(request.getParameter("chapter"));
        String lang = request.getParameter("lang");
        return questionService.getQuestionByChapterId(chapter,lang);
    }
    @ResponseBody
    @RequestMapping("get_question_chapter")
    public List<Chapter> getQuestionChapter(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        return questionService.getQuestionChapterList(lang);
    }
}
