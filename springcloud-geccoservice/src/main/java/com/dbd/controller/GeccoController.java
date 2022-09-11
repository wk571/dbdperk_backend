package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.jedis.RedisDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/post")
public class GeccoController {
    @Resource
    RedisDao redisDao = new RedisDao();
    @GetMapping("/sacred")
    public ApiResult<Map<String, Object>> sacred(){
        Map<String,Object> map = redisDao.sacredPlace();
//                bmsPostService.sacredPlace();
        return ApiResult.success(map);
    }
}
