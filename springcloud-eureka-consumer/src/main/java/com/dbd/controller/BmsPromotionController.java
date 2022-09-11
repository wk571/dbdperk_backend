package com.dbd.controller;

import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Promotion;
import com.dbd.service.BmsPromotionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/sacredplace")
public class BmsPromotionController extends BaseController {
    @Resource
    private BmsPromotionService bmsPromotionService;

    @GetMapping("/all")
    public ApiResult<List<Promotion>> list(){
        List<Promotion> list = bmsPromotionService.list();
        return ApiResult.success(list);
    }

}
