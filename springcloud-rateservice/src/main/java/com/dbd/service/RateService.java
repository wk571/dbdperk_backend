package com.dbd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.entity.Post;
import com.dbd.model.entity.Rate;

import java.util.Map;

public interface RateService extends IService<Rate> {
    Map<String,Object> getRate(Integer sperkId, long useId);
    Map<String,Object> postRate(Integer sperkId, long userId, Integer appearance, Integer popularity, Post post);
    Map<String,Object> deleteRate(Integer sperkId, long useId);
}
