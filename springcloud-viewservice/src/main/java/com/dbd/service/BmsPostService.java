package com.dbd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.entity.Post;
import com.dbd.model.vo.PostVO;

import java.util.List;
import java.util.Map;


public interface BmsPostService extends IService<Post> {

    /**
     * 获取首页话题列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);
    /**
     * 发布
     *
     * @param dto
     * @param principal
     * @return
     */
//    Post create(CreateTopicDTO dto, User principal);

    /**
     * 查看话题详情
     *
     * @param id
     * @return
     */
    Map<String, Object> viewTopic(String id);
    /**
     * 获取随机推荐10篇
     *
     * @param id
     * @return
     */
    List<Post> getRecommend(String id);
    /**
     * 关键字检索
     *
     * @param keyword
     * @param page
     * @return
     */
    Page<PostVO> searchByKey(String keyword, Page<PostVO> page);

    /**
     * 前端发送数据来对技能进行评分，这其中的评分操作是对survivorperks进行的
     * 用来记录对这个技能的总评分
     * @param id
     * @param appearance
     * @param popularity
     * @return
     */
    Map<String,Object> ratePerk(String id, int appearance, int popularity);

    Map<String,Object> unratePerk(String id, int appearance, int popularity);

//    Map<String,Object> sacredPlace();
}
