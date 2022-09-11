package com.dbd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbd.model.entity.Promotion;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsPromotionMapper extends BaseMapper<Promotion> {
    //使用Mybatis Plus提供的list函数返回列表就行，不需要自定义函数然后写xml文件
}
