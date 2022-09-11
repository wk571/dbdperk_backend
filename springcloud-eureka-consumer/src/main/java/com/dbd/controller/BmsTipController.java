package com.dbd.controller;

import com.dbd.client.ViewServiceClient;
import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Tip;
import com.dbd.service.BmsTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/tip")
public class BmsTipController extends BaseController {
//    @Resource
//    private BmsTipService bmsTipService;

    @Autowired
    private ViewServiceClient viewServiceClient;
    @GetMapping("/today")
    public ApiResult<Tip> getRandomTip(){
        return viewServiceClient.getRandomTip();
//        Tip tip = bmsTipService.getRandomTip();
//        return ApiResult.success(tip);
    }
}
