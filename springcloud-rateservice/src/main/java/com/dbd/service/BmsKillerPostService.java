package com.dbd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dbd.model.entity.KillerPost;
import com.dbd.model.entity.Post;
import com.dbd.model.vo.PostVO;

import java.util.List;
import java.util.Map;

public interface BmsKillerPostService extends IService<KillerPost> {

    Map<String,Object> ratePerk(String id, int appearance, int popularity);

    Map<String,Object> unratePerk(String id, int appearance, int popularity);

}
