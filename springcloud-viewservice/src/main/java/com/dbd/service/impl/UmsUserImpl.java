package com.dbd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.common.api.ApiResult;
import com.dbd.mapper.UmsUserMapper;
import com.dbd.model.dto.LoginDTO;
import com.dbd.model.dto.RegisterDTO;
import com.dbd.model.entity.User;
import com.dbd.model.vo.ProfileVO;
import com.dbd.model.vo.RateVO;
import com.dbd.service.UmsUserService;
import com.dbd.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UmsUserImpl extends ServiceImpl<UmsUserMapper, User> implements UmsUserService {

    @Override
    public User getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }



}
