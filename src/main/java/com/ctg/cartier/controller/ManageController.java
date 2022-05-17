package com.ctg.cartier.controller;

import com.ctg.cartier.pojo.dto.ManageDto;
import com.ctg.cartier.pojo.dto.ManageSaleReportDto;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;
import com.ctg.cartier.pojo.until.Result;
import com.ctg.cartier.service.ManageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.ctg.cartier.pojo.until.Constant.*;

@Api(tags = "管理后台")
@CrossOrigin
@RequestMapping("/manage")
@RestController
@Slf4j
public class ManageController {
    @Autowired
    ManageService manageService;

    @PostMapping("/qrySellDetail")
    public Result<FindOperatInfoDto<ManageSaleReportDto>> qrySellDetail(@RequestBody ManageDto manageDto) {
        FindOperatInfoDto<ManageSaleReportDto> findOperatInfoDto = manageService.qrySaleReport(manageDto);
        return new Result<FindOperatInfoDto<ManageSaleReportDto>>(sucCode, sucMsg, findOperatInfoDto);
    }
}
