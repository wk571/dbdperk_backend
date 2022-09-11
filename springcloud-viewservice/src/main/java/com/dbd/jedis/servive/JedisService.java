package com.dbd.jedis.servive;

import com.dbd.model.vo.CommentVO;

import java.util.List;

public interface JedisService {
    public List<CommentVO> getSurvivorPerkComment();
}
