package com.dbd.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private String id;

    private String content;

    private String perkId;

    private String userId;

    private String username;

    private Date createTime;
}
