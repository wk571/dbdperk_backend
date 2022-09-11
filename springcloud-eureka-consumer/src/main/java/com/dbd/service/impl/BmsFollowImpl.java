package com.dbd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.mapper.BmsFollowMapper;
import com.dbd.model.entity.Follow;
import com.dbd.service.BmsFollowService;
import org.springframework.stereotype.Service;

@Service
public class BmsFollowImpl extends ServiceImpl<BmsFollowMapper, Follow> implements BmsFollowService {
}
