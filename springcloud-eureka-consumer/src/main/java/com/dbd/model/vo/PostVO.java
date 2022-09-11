package com.dbd.model.vo;

import com.dbd.model.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO implements Serializable {
    private static final long serialVersionUID = -261082150965211545L;
    /**
     *技能ID
     */
    private String id;
    /**
     * 技能名称
     */
    private String title;
    /**
    *技能描述
     */
    private String description;
    /**
     *
     */
    private String resource;
    /**
     * 技能图标
     */
    private String imgUrl;
    /**
    *出现指数和受欢迎指数
     */
    private int appearance;
    private int popularity;
    /**
     * 用户昵称
     */
//    private String alias;
    /**
     * 账号
     */
//    private String username;

    /**
     * 评论统计
     */
    private String content;
    /**
     *
     */
    private String userId;
    /**
     *
     */
    private Integer perkId;
    /**
     *
     */
    private Integer like_number;

    /**
     * 置顶
     */
    private Boolean top;
    /**
     * 加精
     */
    private Boolean essence;
    /**
     * 收藏次數
     */
//    private Integer collects;
    /**
     * 话题关联标签
     */
    private List<Tag> tags;
    /**
     * 浏览量
     */
//    private Integer view;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
}
