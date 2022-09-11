package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Tip;
import com.dbd.service.BmsTipService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/tip")
public class BmsTipController extends BaseController {
    @Resource
    private BmsTipService bmsTipService;
    @GetMapping("/today")
    public ApiResult<Tip> getRandomTip(){
        Tip tip = bmsTipService.getRandomTip();
        return ApiResult.success(tip);
    }
}
