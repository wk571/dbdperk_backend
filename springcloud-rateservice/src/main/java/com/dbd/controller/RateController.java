package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Post;
import com.dbd.service.BmsPostService;
import com.dbd.service.RateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rate")
public class RateController extends BaseController {

    @Resource
    private RateService rateService;

    @Resource
    private BmsPostService bmsPostService;

    @GetMapping("/get")
    public ApiResult<Map<String,Object>> getRate(@RequestParam("sperkId")int sperkId,
                                  @RequestParam("userId")long userId){
        Map<String,Object> map = rateService.getRate(sperkId,userId);
         return ApiResult.success(map);
    }

    @GetMapping("/post")
    public ApiResult<Map<String,Object>> postRate(@RequestParam("sperkId")int sperkId,
                                                 @RequestParam("userId")long userId,
                                                  @RequestParam("appearance")int appearance,
                                                  @RequestParam("popularity")int popularity){
        Post post =bmsPostService.getById(sperkId);
        Map<String,Object> map = rateService.postRate(sperkId,userId,appearance,popularity,post);
        bmsPostService.ratePerk(String.valueOf(sperkId),appearance,popularity);
        return ApiResult.success(map);
    }

    @CrossOrigin
    @GetMapping("/delete")
    public ApiResult<Map<String,Object>> deleteRate(@RequestParam("sperkId")int sperkId,
                                                    @RequestParam("userId")long userId,
                                                    @RequestParam("appearance")int appearance,
                                                    @RequestParam("popularity")int popularity){
        Map<String,Object> map = rateService.deleteRate(sperkId,userId);
        bmsPostService.unratePerk(String.valueOf(sperkId),appearance,popularity);
        return ApiResult.success(map);
    }
}
