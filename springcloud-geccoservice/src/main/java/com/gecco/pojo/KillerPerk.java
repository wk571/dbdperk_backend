package com.gecco.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("killerperks")
public class KillerPerk {
    private int id;
    private String title;
    private String resource;
    private String description;
    private String imgUrl;
    private int appearance;
    private int popularity;


    public KillerPerk(String title, String resource, String description, String imgUrl) {
        this.title = title;
        this.resource = resource;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}