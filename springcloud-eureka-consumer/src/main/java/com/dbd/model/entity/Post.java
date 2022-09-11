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
@TableName("survivorperks")
public class Post implements Serializable {

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
     * 浏览数
     */
    @TableField("view")
    @Builder.Default
    private Integer view = 0;

}

