package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.KillerPost;
import com.dbd.service.BmsKillerPostService;
import com.dbd.service.KillerRateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/killerrate")
public class KillerRateController extends BaseController {

    @Resource
    private KillerRateService killerRateService;

    @Resource
    private BmsKillerPostService bmsPostService;

    @GetMapping("/get")
    public ApiResult<Map<String,Object>> getRate(@RequestParam("kperkId")int kperkId,
                                                 @RequestParam("userId")long userId){
        Map<String,Object> map = killerRateService.getRate(kperkId,userId);
        return ApiResult.success(map);
    }

    @GetMapping("/post")
    public ApiResult<Map<String,Object>> postRate(@RequestParam("kperkId")int kperkId,
                                                  @RequestParam("userId")long userId,
                                                  @RequestParam("appearance")int appearance,
                                                  @RequestParam("popularity")int popularity){
        KillerPost post = bmsPostService.getById(kperkId);
        Map<String,Object> map = killerRateService.postRate(kperkId,userId,appearance,popularity,post);
        bmsPostService.ratePerk(String.valueOf(kperkId),appearance,popularity);
        return ApiResult.success(map);
    }

    @CrossOrigin
    @GetMapping("/delete")
    public ApiResult<Map<String,Object>> deleteRate(@RequestParam("kperkId")int kperkId,
                                                    @RequestParam("userId")long userId,
                                                    @RequestParam("appearance")int appearance,
                                                    @RequestParam("popularity")int popularity){
        Map<String,Object> map = killerRateService.deleteRate(kperkId,userId);
        bmsPostService.unratePerk(String.valueOf(kperkId),appearance,popularity);
        return ApiResult.success(map);
    }
}
