package com.dbd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.dto.LoginDTO;
import com.dbd.model.dto.RegisterDTO;
import com.dbd.model.entity.User;
import com.dbd.model.vo.ProfileVO;
import com.dbd.model.vo.RateVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmsUserService extends IService<User> {

    User executeRegister(RegisterDTO dto);
    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    User getUserByUsername(String username);
    /**
     * 用户登录
     *
     * @param dto
     * @return 生成的JWT的token
     */
    String executeLogin(LoginDTO dto);

    ProfileVO getUserProfile(String id);

    List<RateVO> getUserRate(String id);
}
