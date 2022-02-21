package com.cjr.elec.modules.elec.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author CJR
 * @create 2022-02-08-14:04
 */
@Data
public class InsertDto {
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date time;
    private Float elec;
}
