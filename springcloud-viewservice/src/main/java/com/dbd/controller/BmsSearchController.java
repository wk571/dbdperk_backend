package com.dbd.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbd.common.api.ApiResult;
import com.dbd.model.vo.PostVO;
import com.dbd.service.BmsKillerPostService;
import com.dbd.service.BmsPostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/search")
public class BmsSearchController extends BaseController {
    @Resource
    private BmsPostService postService;

    @Resource
    private BmsKillerPostService bmsKillerPostService;

    @GetMapping("/survivor")
    public ApiResult<Page<PostVO>> searchList(@RequestParam("keyword") String keyword,
                                              @RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize) {
        Page<PostVO> results = postService.searchByKey(keyword, new Page<>(pageNum, pageSize));
        return ApiResult.success(results);
    }
    @GetMapping("/killer")
    public ApiResult<Page<PostVO>> searchKillerList(@RequestParam("keyword") String keyword,
                                                    @RequestParam("pageNum") Integer pageNum,
                                                    @RequestParam("pageSize") Integer pageSize) {
        Page<PostVO> results = bmsKillerPostService.searchByKey(keyword, new Page<>(pageNum, pageSize));
        return ApiResult.success(results);
    }
}
