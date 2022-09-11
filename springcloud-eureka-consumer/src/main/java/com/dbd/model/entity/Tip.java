package com.dbd.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@Accessors(chain = true)
@TableName("bms_tip")
@NoArgsConstructor
@AllArgsConstructor
public class Tip implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 公告牌
     */
    @TableField("content")
    private String content;

    /**
     * 公告时间
     */
    @TableField(value = "author", fill = FieldFill.INSERT)
    private String author;

    /**
     * 1：展示中，0：过期
     */
    @Builder.Default
    @TableField("`show`")
    private boolean show = false;
}
