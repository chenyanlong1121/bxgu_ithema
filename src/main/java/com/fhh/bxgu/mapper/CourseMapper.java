package com.fhh.bxgu.mapper;

import com.fhh.bxgu.entity.Course;
import com.fhh.bxgu.entity.History;
import com.fhh.bxgu.entity.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    int insertCourseInfoEnUs(@Param("courses")List<Course> courses);
    int insertHistory(@Param("courseid") int courseid,@Param("username") String username);
    List<History> getHistory(@Param("username") String username);
    List<Course> getCourseInfoEnUs();
    List<Course> getCourseInfoZhCn();
    List<Course> getCourseInfoEnUsById(int course_id);
    List<Course> getCourseInfoZhCnById(int course_id);
    int insertCourseInfoZhCn(@Param("courses")List<Course> courses);
    List<Video> getVideoInfoZhCn();
    List<Video> getVideoInfoEnUs();
}
