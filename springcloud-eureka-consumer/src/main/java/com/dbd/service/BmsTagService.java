package com.dbd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.entity.Post;
import com.dbd.model.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BmsTagService extends IService<Tag> {
    /**
     * 插入标签
     *
     * @param tags
     * @return
     */
    List<Tag> insertTags(List<String> tags);
    /**
     * 获取标签关联话题
     *
     * @param topicPage
     * @param id
     * @return
     */
    Page<Post> selectTopicsByTagId(Page<Post> topicPage, String id);
}
