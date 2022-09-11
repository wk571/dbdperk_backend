package com.dbd.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("killerperks")
public class KillerPost implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 标题
     */
    @NotBlank(message = "标题不可以为空")
    @TableField(value = "title")
    private String title;
    /**
     * markdown
     */
    @NotBlank(message = "内容不可以为空")
    @TableField("resource")
    private String resource;
    @NotBlank(message = "内容不可以为空")
    @TableField("description")
    private String content;

    /**
     * 作者ID
     */
    @TableField("imgUrl")
    private String imgUrl;

    @TableField("appearance")
    private Integer appearance;

    @TableField("appearpeople")
    private Integer appearpeople;

    @TableField("popularity")
    private Integer popularity;

    @TableField("poppeople")
    private Integer poppeople;
    /**
     * 评论数
     */
//    @TableField("comments")
//    @Builder.Default
//    private Integer comments = 0;

    /**
     * 收藏数
     */
//    @TableField("collects")
//    @Builder.Default
//    private Integer collects = 0;

    /**
     * 浏览数
     */
    @TableField("view")
    @Builder.Default
    private Integer view = 0;

    /**
     * 专栏ID，默认不分栏
     */
//    @TableField("section_id")
//    @Builder.Default
//    private Integer sectionId = 0;

    /**
     * 置顶
     */
//    @TableField("top")
//    @Builder.Default
//    private Boolean top = false;

    /**
     * 加精
     */
//    @TableField("essence")
//    @Builder.Default
//    private Boolean essence = false;

    /**
     * 创建时间
     */
//    @TableField(value = "create_time", fill = FieldFill.INSERT)
//    private Date createTime;

    /**
     * 修改时间
     */
//    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
//    private Date modifyTime;
}
