package com.cjr.elec.modules.elec.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CJR
 * @create 2022-02-09-16:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DurationVO {
    private Integer hour;
    private Integer minute;
    private Integer second;
}
