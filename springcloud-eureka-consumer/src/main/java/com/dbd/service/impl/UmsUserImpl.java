package com.dbd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dbd.common.api.ApiResult;
import com.dbd.jwt.JwtUtil;
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
public class UmsUserImpl extends ServiceImpl<UmsUserMapper,User> implements UmsUserService {
    @Override
    public User executeRegister(RegisterDTO dto) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,dto.getName()).or().eq(User::getEmail,dto.getEmail());
        User umsUser = baseMapper.selectOne(wrapper);
        if(!ObjectUtils.isEmpty(umsUser)){
            ApiResult.failed("账号或邮箱已存在！");
        }
        User addUser = User.builder()
                .username(dto.getName())
                .alias(dto.getName())
                .password(MD5Utils.getPwd(dto.getPass()))
                .email(dto.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);
        return addUser;
    }

    @Override
    public User getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }


    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;
        try {
            User user = getUserByUsername(dto.getUsername());
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if(!encodePwd.equals(user.getPassword()))
            {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}" , dto.getUsername());
        }
        return token;
    }

    @Override
    public ProfileVO getUserProfile(String id) {
        ProfileVO profile = new ProfileVO();
        User user = baseMapper.selectById(id);
        BeanUtils.copyProperties(user,profile);
        return profile;
    }

    public List<RateVO> getUserRate(String id){
        List<RateVO> slist = this.baseMapper.getRateByUser(id);
        List<RateVO> klist = this.baseMapper.getKillerRateByUser(id);
        slist.addAll(klist);
        return slist;
    }
}
