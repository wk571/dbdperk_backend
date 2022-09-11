package com.dbd.client;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbd.common.api.ApiResult;
import com.dbd.model.entity.Billboard;
import com.dbd.model.entity.Post;
import com.dbd.model.entity.Promotion;
import com.dbd.model.entity.Tip;
import com.dbd.model.vo.PostVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "eureka-viewservice")
public interface ViewServiceClient {

    @GetMapping("/tip/today")
    ApiResult<Tip> getRandomTip();

    @GetMapping("/search/survivor")
    ApiResult<Page<PostVO>> searchList(@RequestParam("keyword") String keyword,
                                              @RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize);

    @GetMapping("/search/killer")
    ApiResult<Page<PostVO>> searchKillerList(@RequestParam("keyword") String keyword,
                                                    @RequestParam("pageNum") Integer pageNum,
                                                    @RequestParam("pageSize") Integer pageSize);

    @GetMapping("/sacredplace/all")
    ApiResult<List<Promotion>> getPromotionlist();

    @GetMapping("/billboard/show")
    ApiResult<Billboard> getNotices();

    @GetMapping("/post/list")
    ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize);

    @GetMapping("/post/recommend")
    ApiResult<List<Post>> getRecommend(@RequestParam("topicId") String id);
}
