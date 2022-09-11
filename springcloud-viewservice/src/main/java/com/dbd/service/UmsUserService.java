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

    /**
     * 获取用户信息
     *
     * @param username
     * @return dbUser
     */
    User getUserByUsername(String username);

}
