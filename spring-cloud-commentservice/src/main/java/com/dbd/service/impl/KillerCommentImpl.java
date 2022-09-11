package com.dbd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.KillerCommentMapper;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.KillerComment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;
import com.dbd.service.KillerCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class KillerCommentImpl extends ServiceImpl<KillerCommentMapper, KillerComment>
        implements KillerCommentService {

    @Override
    public List<CommentVO> getCommentsByTopicID(String topicid) {
        List<CommentVO> lstBmsComment = new ArrayList<CommentVO>();
        try {
            lstBmsComment = this.baseMapper.getCommentsByTopicID(topicid);
        } catch (Exception e) {
            log.info("lstBmsComment失败");
        }
        return lstBmsComment;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public KillerComment create(CommentDTO dto, User user) {
        KillerComment comment = KillerComment.builder()
                .userId(user.getId())
                .content(dto.getContent())
                .perkId(dto.getTopic_id())
                .createTime(new Date())
                .build();
        this.baseMapper.insert(comment);
        return comment;
    }
}
