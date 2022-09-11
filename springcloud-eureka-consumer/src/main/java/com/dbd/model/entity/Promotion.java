package com.dbd.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@Accessors(chain = true)
@TableName("sacredplace")
@NoArgsConstructor
@AllArgsConstructor

public class Promotion implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;

    @TableField("title")
    private String title;

    @TableField("link")
    private String link;

    @TableField("description")
    private String description;
}
