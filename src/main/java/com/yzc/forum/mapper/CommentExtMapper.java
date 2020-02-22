package com.yzc.forum.mapper;

import com.yzc.forum.model.Comment;


public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}