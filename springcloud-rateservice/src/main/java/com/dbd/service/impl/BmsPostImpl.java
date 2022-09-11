package com.dbd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dbd.mapper.BmsTopicMapper;

import com.dbd.model.entity.Post;
import com.dbd.model.entity.Tag;
import com.dbd.model.entity.TopicTag;
import com.dbd.model.vo.PostVO;
import com.dbd.service.BmsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class BmsPostImpl extends ServiceImpl<BmsTopicMapper, Post> implements BmsPostService {



    @Override
    public Map<String, Object> ratePerk(String id, int appearance, int popularity) {
        Post perk = this.baseMapper.selectById(id);
        perk.setAppearpeople((perk.getAppearpeople() == null ? 0 : perk.getAppearpeople()) + 1);
        perk.setAppearance((perk.getAppearance() == null ? 0 : perk.getAppearance()) + appearance);
        perk.setPoppeople((perk.getPoppeople() == null ? 0 : perk.getPoppeople()) + 1);
        perk.setPopularity((perk.getPopularity() == null ? 0 :perk.getPopularity())+ popularity);
        this.baseMapper.updateById(perk);
        Map<String,Object> map = new HashMap<>(16);
        map.put("topic",perk);
        return map;
    }


    public Map<String,Object> unratePerk(String id,int appearance,int popularity){
        Post perk = this.baseMapper.selectById(id);
        perk.setAppearpeople((perk.getAppearpeople() == null ? 0 : perk.getAppearpeople()) - 1);
        perk.setAppearance((perk.getAppearance() == null ? 0 : perk.getAppearance()) - appearance);
        perk.setPoppeople((perk.getPoppeople() == null ? 0 : perk.getPoppeople()) - 1);
        perk.setPopularity((perk.getPopularity() == null ? 0 :perk.getPopularity()) - popularity);
        this.baseMapper.updateById(perk);
        Map<String,Object> map = new HashMap<>(16);
        map.put("topic",perk);
        return map;
    }

}
