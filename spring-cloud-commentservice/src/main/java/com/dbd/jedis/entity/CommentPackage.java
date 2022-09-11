package com.dbd.jedis.entity;

import com.dbd.model.vo.CommentVO;

import java.io.Serializable;
import java.util.List;

public class CommentPackage implements Serializable {

    private static final long serialVersionUID = 2L;

    private List<CommentVO> info;
    public List<CommentVO> getInfo(){
        return this.info;
    }
    public void setInfo(List<CommentVO> info){
        this.info=info;
    }

    public CommentPackage(List<CommentVO> info){
        this.info=info;
    }
}
