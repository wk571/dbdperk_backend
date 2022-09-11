package com.dbd.client;

import com.dbd.common.api.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-geccoservice")
public interface GeccoserviceClient {
    @GetMapping("/post/sacred")
    ApiResult sacred();
}
