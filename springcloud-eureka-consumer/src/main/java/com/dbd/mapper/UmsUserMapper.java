package com.dbd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbd.model.entity.User;
import com.dbd.model.vo.RateVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsUserMapper extends BaseMapper<User> {

    List<RateVO> getRateByUser(String id);

    List<RateVO> getKillerRateByUser(String id);
}
