package com.dbd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.entity.Tip;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsTipService extends IService<Tip> {
    Tip getRandomTip();
}
