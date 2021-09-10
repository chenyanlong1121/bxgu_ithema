package com.fhh.bxgu.mapper;

import com.fhh.bxgu.entity.Chapter;
import com.fhh.bxgu.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {
    int addExerciseZhCn(@Param("question") List<Question> questionList);
    int addExerciseEnUs(@Param("question") List<Question> questionList);
    List<Question> getQuestionByChapterIdEnUs(@Param("id") int id);
    List<Question> getQuestionByChapterIdZhCn(@Param("id") int id);
    List<Chapter> getQuestionChapterListEnUs();
    List<Chapter> getQuestionChapterListZhCn();
}
