package com.yzc.forum.mapper;

import com.yzc.forum.dto.QuestionQueryDTO;
import com.yzc.forum.model.Question;

import java.util.List;


public interface QuestionExtMapper {
    int incView (Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}