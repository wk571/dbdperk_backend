package com.dbd.jedis.entity;

import java.io.Serializable;
import java.util.Map;

public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String,Object> info;
    public Map<String,Object> getInfo(){
        return this.info;
    }
    public void setInfo(Map<String,Object> info){
        this.info=info;
    }

    public Data(Map<String,Object> info){
        this.info=info;
    }
}
