package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.jedis.RedisDao;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.Comment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;
import com.dbd.service.BmsCommentService;
import com.dbd.service.UmsUserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RequestMapping("/comment")
@RestController
public class SurvivorCommentController extends BaseController {
    @Resource
    private BmsCommentService bmsCommentService;
    @Resource
    private UmsUserService umsUserService;

    @Resource
    private RedisDao redisDao;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid") String topicid) {
        List<CommentVO> lstBmsComment = redisDao.getSurvivorPerkComment(topicid);
        return ApiResult.success(lstBmsComment);
    }
    @PostMapping("/add_comment")
    public ApiResult<Comment> add_comment(@RequestParam(value = "username")String userName,@RequestBody CommentDTO dto) {
        User user = umsUserService.getUserByUsername(userName);
        Comment comment = bmsCommentService.create(dto, user);
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(dto.getTopic_id());
        redisDao.addSurvivorPerkComment(dto.getTopic_id(),lstBmsComment);
        return ApiResult.success(comment);
    }
}
