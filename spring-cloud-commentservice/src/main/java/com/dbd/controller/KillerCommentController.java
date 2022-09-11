package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.jedis.RedisDao;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.KillerComment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;
import com.dbd.service.KillerCommentService;
import com.dbd.service.UmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RequestMapping("/killercomment")
@RestController
public class KillerCommentController extends BaseController {
    @Resource
    private KillerCommentService bmsCommentService;
    @Resource
    private UmsUserService umsUserService;
    @Resource
    private RedisDao redisDao;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        List<CommentVO> lstBmsComment = redisDao.getKillerPerkComment(topicid);
        return ApiResult.success(lstBmsComment);
    }

    @PostMapping("/add_comment")
    public ApiResult<KillerComment> add_comment(@RequestParam(value = "username")String userName,@RequestBody CommentDTO dto) {
        User user = umsUserService.getUserByUsername(userName);
        KillerComment comment = bmsCommentService.create(dto, user);
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(dto.getTopic_id());
        redisDao.addKillerPerkComment(userName,lstBmsComment);
        return ApiResult.success(comment);
    }
}
