package com.dbd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.RateMapper;
import com.dbd.model.entity.Post;
import com.dbd.model.entity.Rate;
import com.dbd.model.entity.User;
import com.dbd.model.vo.PerkUserVO;
import com.dbd.model.vo.PostVO;
import com.dbd.service.RateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RateImpl extends ServiceImpl<RateMapper, Rate> implements RateService {

    public Map<String,Object> getRate(Integer sperkId, long useId){
        PerkUserVO perkUserVO = new PerkUserVO(useId,sperkId);
        Rate rate = this.baseMapper.getRate(perkUserVO);
        Map<String,Object> map = new HashMap<>();
        if(rate == null) map.put("rated",0);
        else map.put("rated",1);
        map.put("data",rate);
        return map;
    }
    public Map<String,Object> postRate(Integer sperkId, long useId,
                                       Integer appearance, Integer popularity, Post post){
        Rate newRate = new Rate(useId,sperkId,appearance,popularity,post);
        Map<String,Object> map = new HashMap<>();
        this.baseMapper.insert(newRate);
        map.put("rated",1);
        map.put("data",newRate);
        return map;
    }

    public Map<String,Object> deleteRate(Integer sperkId, long useId){
        PerkUserVO perkUserVO = new PerkUserVO(useId,sperkId);
        this.baseMapper.deleteRate(perkUserVO);
        Map<String,Object> map = new HashMap<>();
        map.put("rated",0);
        return map;
    }

    public List<PostVO> rateByUser(User user){
        List<PostVO> list = new ArrayList<>();
        list = this.baseMapper.rateByUserSurvivor(user);
        return list;
    }
}
