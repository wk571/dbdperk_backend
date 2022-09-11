package com.dbd.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName("user_kperk_rate")
@NoArgsConstructor
public class KillerRate implements Serializable {

    private static final long serialVersionUID = 3257790983905872243L;

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private long id;

    @TableField("user_id")
    private long userId;

    @TableField("kperk_id")
    private int kperkId;

    @TableField("appearance")
    private Integer appearance;

    @TableField("popularity")
    private Integer popularity;

    @TableField("title")
    private String title;

    @TableField("imgUrl")
    private String imgUrl;

    public KillerRate(long userId, int kperkId, Integer appearance, Integer popularity,KillerPost post) {
        this.userId = userId;
        this.kperkId = kperkId;
        this.appearance = appearance;
        this.popularity = popularity;
        this.title = post.getTitle();
        this.imgUrl = post.getImgUrl();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
