package com.dbd.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerkUserVO {
    /**
     * 用户的Id
     */
    private long userId;
    /**
     * 技能的Id
     */
    private Integer perkId;
}
