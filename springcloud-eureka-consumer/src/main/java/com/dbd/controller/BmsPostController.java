package com.dbd.controller;
/**
 * 负责主页数据的获取
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbd.client.GeccoserviceClient;
import com.dbd.common.api.ApiResult;
import com.dbd.jedis.RedisDao;
import com.dbd.model.entity.Post;
import com.dbd.model.vo.PostVO;
import com.dbd.service.BmsKillerPostService;
import com.dbd.service.BmsPostService;
import com.dbd.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/post")
public class BmsPostController extends BaseController {

    RedisDao redisDao = new RedisDao();

    @Resource
    private BmsPostService bmsPostService;

    @Resource
    private BmsKillerPostService bmsKillerPostService;

    @Resource
    private UmsUserService umsUserService;

    @Autowired
    private GeccoserviceClient geccoserviceClient;

    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<PostVO> list;
        if(tab.equals("latest"))
        list = bmsPostService.getList(new Page(pageNo, pageSize), tab);
        else list = bmsKillerPostService.getList(new Page(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }

    @GetMapping("/sacred")
    public ApiResult<Map<String, Object>> sacred(){
        return geccoserviceClient.sacred();
//        Map<String,Object> map = redisDao.sacredPlace();
//        return ApiResult.success(map);
    }

    @GetMapping()
    public ApiResult<Map<String, Object>> view(@RequestParam("id") String id) {
        //将url中的参数id传入当做参数
        //如https://www.bilibili.com/video/BV1Wz4y1U7vC?p=40&id=pageDriver
        Map<String, Object> map = bmsPostService.viewTopic(id);
        return ApiResult.success(map);
    }

    /**
     * 感觉这个函数应该要删除
     * @param id
     * @param appearance
     * @param popularity
     * @return
     */
    @GetMapping("/rate")
    public ApiResult<Map<String, Object>> ratePerk(@RequestParam("perkId") String id,
                                                   @RequestParam("appearance") String appearance,
                                                   @RequestParam("popularity") String popularity) {
        Map<String,Object> map = bmsPostService.ratePerk(id,Integer.parseInt(appearance),
                Integer.parseInt(popularity));
        return ApiResult.success(map);
    }

    @GetMapping("/killer")
    public ApiResult<Map<String, Object>> viewKiller(@RequestParam("id") String id) {
        Map<String, Object> map = bmsKillerPostService.viewTopic(id);
        return ApiResult.success(map);
    }

    @GetMapping("/recommend")
    public ApiResult<List<Post>> getRecommend(@RequestParam("topicId") String id) {
        List<Post> topics = bmsPostService.getRecommend(id);
        return ApiResult.success(topics);
    }
}
