package com.dbd.client;

import com.dbd.common.api.ApiResult;
import com.dbd.model.dto.CommentDTO;
import com.dbd.model.entity.Comment;
import com.dbd.model.entity.KillerComment;
import com.dbd.model.entity.User;
import com.dbd.model.vo.CommentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "eureka-commentservice")
public interface CommentServiceClient {

    @GetMapping("/comment/get_comments")
    ApiResult<List<CommentVO>> getSurvivorCommentsByTopicID(@RequestParam("topicid") String topicid);
    @PostMapping("/comment/add_comment")
    ApiResult<Comment> addSurvivorComment(@RequestParam("username")String userName, @RequestBody CommentDTO dto);

    @GetMapping("/killercomment/get_comments")
    ApiResult<List<CommentVO>> getKillerCommentsByTopicID(@RequestParam("topicid")String topicid);
    @PostMapping("/killercomment/add_comment")
    ApiResult<KillerComment> addKillerComment(@RequestParam("username")String userName, @RequestBody CommentDTO dto);
}
