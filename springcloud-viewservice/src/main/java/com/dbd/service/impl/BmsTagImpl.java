package com.dbd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.BmsTagMapper;
import com.dbd.model.entity.Post;
import com.dbd.model.entity.Tag;
import com.dbd.service.BmsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BmsTagImpl extends ServiceImpl<BmsTagMapper, Tag> implements BmsTagService {
    @Autowired
    private com.dbd.service.BmsTopicTagService bmsTopicTagService;

    @Autowired
    private com.dbd.service.BmsPostService IBmsPostService;
    @Override
    public List<Tag> insertTags(List<String> tagNames) {
        List<Tag> tagList = new ArrayList<>();
        for (String tagName : tagNames) {
            Tag tag = this.baseMapper.selectOne(new LambdaQueryWrapper<Tag>().eq(Tag::getName, tagName));
            if (tag == null) {
                tag = Tag.builder().name(tagName).build();
                this.baseMapper.insert(tag);
            } else {
                tag.setTopicCount(tag.getTopicCount() + 1);
                this.baseMapper.updateById(tag);
            }
            tagList.add(tag);
        }
        return tagList;
    }

    @Override
    public Page<Post> selectTopicsByTagId(Page<Post> topicPage, String id) {

        // 获取关联的话题ID
        Set<String> ids = bmsTopicTagService.selectTopicIdsByTagId(id);
        LambdaQueryWrapper<Post> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Post::getId, ids);

        return IBmsPostService.page(topicPage, wrapper);
    }
}
