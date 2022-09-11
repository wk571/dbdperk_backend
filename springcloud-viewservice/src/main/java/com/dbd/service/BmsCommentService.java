package com.dbd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.Comment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;

import java.util.List;


public interface BmsCommentService extends IService<Comment> {
    /**
     *
     *
     * @param topicid
     * @return {@link Comment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    Comment create(CommentDTO dto, User principal);
}
