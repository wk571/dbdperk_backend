package com.dbd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.Comment;
import com.dbd.model.entity.KillerComment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;

import java.util.List;

public interface KillerCommentService extends IService<KillerComment> {
    /**
     * @param topicid
     * @return {@link Comment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    KillerComment create(CommentDTO dto, User principal);
}
