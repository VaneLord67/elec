package com.cjr.elec.modules.elec.controller;

import com.cjr.elec.common.api.CommonResult;
import com.cjr.elec.modules.elec.dto.InsertDto;
import com.cjr.elec.modules.elec.model.Elec;
import com.cjr.elec.modules.elec.service.ElecService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author CJR
 * @create 2022-02-08-13:30
 */
@RestController
@RequestMapping("/elec")
public class ElecController {

    @Resource
    private ElecService elecService;

    @PostMapping("/insert")
    public CommonResult insertElec(@RequestBody InsertDto dto) {
        Elec insertElec = Elec.builder().elec(dto.getElec()).time(dto.getTime()).build();
        elecService.save(insertElec);
        return CommonResult.success();
    }

    @GetMapping("/get")
    public CommonResult getElecList() {
        List<Elec> elecList = elecService.lambdaQuery().orderByDesc(Elec::getTime).last("limit 20").list();
        return CommonResult.success(elecList);
    }
}
