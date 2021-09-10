package com.fhh.bxgu.controller;

import com.alibaba.fastjson.JSON;
import com.fhh.bxgu.entity.Course;
import com.fhh.bxgu.service.CourseService;
import com.fhh.bxgu.utility.TokenPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @ResponseBody
    @RequestMapping(value = "get_course_data",produces = "application/json")
    public String getCourseData(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String token = request.getParameter("token");
        String lang  = request.getParameter("lang");
        if(TokenPool.validateToken(token)) {
            System.out.println("Valid Token!");
            String id = request.getParameter("course_id");
            if(id==null) {
                return JSON.toJSONString(courseService.getCourseInfo(lang));
            }
            else {
                return JSON.toJSONString(courseService.getCourseInfoById(lang,Integer.parseInt(id)));
            }

        }
        else {
            response.sendError(401);
            return null;
        }
    }
    @ResponseBody
    @RequestMapping(value = "get_video_data",produces = "application/json")
    public String getVideoData(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String token = request.getParameter("token");
        String lang  = request.getParameter("lang");
        if(TokenPool.validateToken(token)) {
            System.out.println("Valid Token!");
            return JSON.toJSONString(courseService.getVideoData(lang));
        }
        else {
            response.sendError(401);
            return null;
        }
    }
    @ResponseBody
    @PostMapping(value = "upload_course",produces = "application/json")
    public String uploadCoursePost(@RequestParam("file") MultipartFile file, @RequestParam("lang") String lang, HttpServletResponse response) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        };
        String fileName = file.getOriginalFilename();
        try {
            String filePath = ResourceUtils.getURL("classpath:").getPath();
            File dest = new File(filePath + "upload/"+fileName);
            file.transferTo(dest);
            List<Course> courses = courseService.parseCourses(dest);
            courseService.insertCourses(courses,lang);
            return JSON.toJSONString(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }
    @RequestMapping(value = "upload_course",method = RequestMethod.GET)
    public String uploadCourse() {
        return "upload_course";
    }
    @RequestMapping(value = "get_chapter_img")
    public String getChapterImg(HttpServletRequest request) {
        String chapterId = request.getParameter("chapter_id");
        String lang = request.getParameter("lang");
        String filename = DigestUtils.md5DigestAsHex((chapterId+"_"+lang).getBytes());
        return "redirect:/images/course/"+filename+".png";
    }
    @RequestMapping(value = "get_video_history", produces = "application/json")
    @ResponseBody
    public String getVideoHistory(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String token = request.getParameter("token");
        String username  = request.getParameter("username");
        if(TokenPool.validateToken(token)) {
            System.out.println("Valid Token!");
            return JSON.toJSONString(courseService.getHistory(username));
        }
        else {
            response.sendError(401);
            return null;
        }
    }
    @RequestMapping(value = "get_video")
    public String getVideo(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String token = request.getParameter("token");
        String username  = request.getParameter("username");
        int courseId = Integer.parseInt(request.getParameter("courseid"));
        if(TokenPool.validateToken(token)) {
            System.out.println("Valid Token!");
            courseService.insertHistory(courseId,username);
            return "redirect:videos/video"+courseId+".mp4";
        }
        else {
            response.sendError(401);
            return null;
        }
    }
}
