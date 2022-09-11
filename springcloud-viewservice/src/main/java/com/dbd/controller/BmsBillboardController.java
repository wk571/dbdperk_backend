package com.dbd.controller;
/**
 * 公告板部分，没什么需要改的，没啥用，可能会删除
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Billboard;
import com.dbd.service.BmsBillboardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController {
    @Resource
    private BmsBillboardService bmsBillboardService;
    @GetMapping("/show")
    public ApiResult<Billboard> getNotices(){
        List<Billboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<Billboard>().eq(Billboard::isShow,true));
        return ApiResult.success(list.get(list.size()- 1));
    }
}
