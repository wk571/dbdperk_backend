package com.dbd.model.vo;

import lombok.Data;

@Data
public class RateVO {
    private static final long serialVersionUID = 3257790983905872243L;

    private Integer id;

    private long userId;

    private int perkId;

    private String title;

    private Integer appearance;

    private Integer popularity;

    private String imgUrl;


}
