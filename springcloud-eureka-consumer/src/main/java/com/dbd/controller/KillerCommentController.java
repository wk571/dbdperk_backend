package com.dbd.controller;

import com.dbd.client.CommentServiceClient;
import com.dbd.common.api.ApiResult;
import com.dbd.jedis.RedisDao;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.KillerComment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;
import com.dbd.service.KillerCommentService;
import com.dbd.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.dbd.jwt.JwtUtil.USER_NAME;

@CrossOrigin
@RequestMapping("/killercomment")
@RestController
public class KillerCommentController extends BaseController {

    @Autowired
    private CommentServiceClient commentServiceClient;


    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        return commentServiceClient.getKillerCommentsByTopicID(topicid);
    }

    @PostMapping("/add_comment")
    public ApiResult<KillerComment> add_comment(@RequestHeader(value = USER_NAME) String userName,
                                          @RequestBody CommentDTO dto) {
        return commentServiceClient.addKillerComment(userName,dto);
    }
}

