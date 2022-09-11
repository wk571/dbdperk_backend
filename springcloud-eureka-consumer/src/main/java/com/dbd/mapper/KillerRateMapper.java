package com.dbd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbd.model.entity.KillerRate;
import com.dbd.model.entity.User;
import com.dbd.model.vo.PerkUserVO;
import com.dbd.model.vo.PostVO;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface KillerRateMapper extends BaseMapper<KillerRate> {
    KillerRate getRate(PerkUserVO perkUserVO);//1
    void  deleteRate(PerkUserVO perkUserVO);//1
    List<PostVO> rateByUserKiller(User user);//同理看看这个是干什么的
}
