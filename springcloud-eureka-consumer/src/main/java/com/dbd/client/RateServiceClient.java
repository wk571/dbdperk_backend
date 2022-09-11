package com.dbd.client;

import com.dbd.common.api.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "eureka-rateservice")
public interface RateServiceClient {
    @GetMapping("/rate/get")
    ApiResult<Map<String,Object>> getSurvivorRate(@RequestParam("sperkId")int sperkId,
                                          @RequestParam("userId")long userId);
    @GetMapping("/rate/post")
    ApiResult<Map<String,Object>> postSurvivorRate(@RequestParam("sperkId")int sperkId,
                                                  @RequestParam("userId")long userId,
                                                  @RequestParam("appearance")int appearance,
                                                  @RequestParam("popularity")int popularity);
    @GetMapping("/rate/delete")
    public ApiResult<Map<String,Object>> deleteSurvivorRate(@RequestParam("sperkId")int sperkId,
                                                    @RequestParam("userId")long userId,
                                                    @RequestParam("appearance")int appearance,
                                                    @RequestParam("popularity")int popularity);
    @GetMapping("/killerrate/get")
    ApiResult<Map<String,Object>> getKillerRate(@RequestParam("kperkId")int kperkId,
                                                  @RequestParam("userId")long userId);
    @GetMapping("/killerrate/post")
    ApiResult<Map<String,Object>> postKillerRate(@RequestParam("kperkId")int kperkId,
                                                   @RequestParam("userId")long userId,
                                                   @RequestParam("appearance")int appearance,
                                                   @RequestParam("popularity")int popularity);

    @GetMapping("/killerrate/delete")
    public ApiResult<Map<String,Object>> deleteKillerRate(@RequestParam("kperkId")int kperkId,
                                                    @RequestParam("userId")long userId,
                                                    @RequestParam("appearance")int appearance,
                                                    @RequestParam("popularity")int popularity);
}
