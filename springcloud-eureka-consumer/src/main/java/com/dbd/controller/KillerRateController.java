package com.dbd.controller;

import com.dbd.client.RateServiceClient;
import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.KillerPost;
import com.dbd.service.BmsKillerPostService;
import com.dbd.service.KillerRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/killerrate")
public class KillerRateController extends BaseController {

    @Autowired
    private RateServiceClient rateServiceClient;

    @GetMapping("/get")
    public ApiResult<Map<String,Object>> getRate(@RequestParam("kperkId")int kperkId,
                                                 @RequestParam("userId")long userId){
        return rateServiceClient.getKillerRate(kperkId,userId);
    }

    @GetMapping("/post")
    public ApiResult<Map<String,Object>> postRate(@RequestParam("kperkId")int kperkId,
                                                  @RequestParam("userId")long userId,
                                                  @RequestParam("appearance")int appearance,
                                                  @RequestParam("popularity")int popularity){
        return rateServiceClient.postKillerRate(kperkId,userId,appearance,popularity);
    }

    @CrossOrigin
    @GetMapping("/delete")
    public ApiResult<Map<String,Object>> deleteRate(@RequestParam("kperkId")int kperkId,
                                                    @RequestParam("userId")long userId,
                                                    @RequestParam("appearance")int appearance,
                                                    @RequestParam("popularity")int popularity){
        return rateServiceClient.deleteKillerRate(kperkId,userId,appearance,popularity);
    }
}
