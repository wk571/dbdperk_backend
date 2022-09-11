package com.dbd.controller;

import com.dbd.client.RateServiceClient;
import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Post;
import com.dbd.service.BmsPostService;
import com.dbd.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rate")
public class RateController extends BaseController {

    @Autowired
    private RateServiceClient rateServiceClient;


    @GetMapping("/get")
    public ApiResult<Map<String,Object>> getRate(@RequestParam("sperkId")int sperkId,
                                  @RequestParam("userId")long userId){
        return rateServiceClient.getSurvivorRate(sperkId,userId);
    }

    @GetMapping("/post")
    public ApiResult<Map<String,Object>> postRate(@RequestParam("sperkId")int sperkId,
                                                 @RequestParam("userId")long userId,
                                                  @RequestParam("appearance")int appearance,
                                                  @RequestParam("popularity")int popularity){
        return rateServiceClient.postSurvivorRate(sperkId, userId, appearance, popularity);
    }

    @CrossOrigin
    @GetMapping("/delete")
    public ApiResult<Map<String,Object>> deleteRate(@RequestParam("sperkId")int sperkId,
                                                    @RequestParam("userId")long userId,
                                                    @RequestParam("appearance")int appearance,
                                                    @RequestParam("popularity")int popularity){
        return rateServiceClient.deleteSurvivorRate(sperkId, userId, appearance, popularity);
    }
}
