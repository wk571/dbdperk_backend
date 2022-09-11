package com.dbd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.entity.KillerPost;
import com.dbd.model.entity.KillerRate;

import java.util.Map;

public interface KillerRateService extends IService<KillerRate> {
    Map<String,Object> getRate(Integer kperkId, long useId);
    Map<String,Object> postRate(Integer kperkId, long iseId, Integer appearance, Integer popularity, KillerPost post);
    Map<String,Object> deleteRate(Integer kperkId, long useId);
}