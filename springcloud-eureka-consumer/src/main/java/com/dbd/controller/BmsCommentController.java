package com.dbd.controller;

/**
 * 负责用户给逃生者技能的后端实现
 */

import com.dbd.client.CommentServiceClient;
import com.dbd.common.api.ApiResult;
import com.dbd.jedis.RedisDao;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.Comment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;
import com.dbd.service.BmsCommentService;
import com.dbd.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.dbd.jwt.JwtUtil.USER_NAME;

@CrossOrigin
@RequestMapping("/comment")
@RestController
public class BmsCommentController extends BaseController {

//    @Resource
//    private BmsCommentService bmsCommentService;
    @Resource
    private UmsUserService umsUserService;
//
//    @Resource
//    private RedisDao redisDao;

    @Autowired
    private CommentServiceClient commentServiceClient;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        return commentServiceClient.getSurvivorCommentsByTopicID(topicid);
    }
    @PostMapping("/add_comment")
    public ApiResult<Comment> add_comment(@RequestHeader(value = USER_NAME) String userName,
                                          @RequestBody CommentDTO dto) {
        return commentServiceClient.addSurvivorComment(userName,dto);
    }
}
