package com.dbd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.BmsPromotionMapper;
import com.dbd.model.entity.Promotion;
import com.dbd.service.BmsPromotionService;
import org.springframework.stereotype.Service;

@Service
public class BmsPromotionImpl extends ServiceImpl<BmsPromotionMapper, Promotion> implements BmsPromotionService {
}
