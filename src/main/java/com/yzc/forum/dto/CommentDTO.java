package com.yzc.forum.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private long parentId;
    private String content;
    private Integer type;
}
