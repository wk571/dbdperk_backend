package com.dbd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbd.model.entity.Rate;
import com.dbd.model.entity.User;
import com.dbd.model.vo.PerkUserVO;
import com.dbd.model.vo.PostVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateMapper extends BaseMapper<Rate> {

    Rate getRate(PerkUserVO perkUserVO);//1
    void  deleteRate(PerkUserVO perkUserVO);//1
    List<PostVO> rateByUserSurvivor(User user);//一会儿看看这个用在哪了
}
