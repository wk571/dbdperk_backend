package com.dbd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.BmsBillboardMapper;
import com.dbd.model.entity.Billboard;
import com.dbd.service.BmsBillboardService;
import org.springframework.stereotype.Service;

@Service
public class BmsBillboardImpl extends ServiceImpl<BmsBillboardMapper, Billboard> implements BmsBillboardService {
}
