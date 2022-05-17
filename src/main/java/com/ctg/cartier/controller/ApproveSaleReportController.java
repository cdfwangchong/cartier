package com.ctg.cartier.controller;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.ctg.cartier.pojo.dto.*;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;
import com.ctg.cartier.pojo.until.Result;
import com.ctg.cartier.service.ApproveSaleRepostService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ctg.cartier.pojo.until.Constant.*;

@Api(tags = "销售日报审核")
@RestController
@RequestMapping("/approve")
@CrossOrigin
public class ApproveSaleReportController {
    @Autowired
    ApproveSaleRepostService approveSaleRepostService;

    @PostMapping("/qryUnApprove")
    @ResponseBody
    public Result<FindOperatInfoDto<SubmitInfoDto>> qryUnApprove(@RequestBody XsdnoDto xsdnoDto) {
        if (StringUtils.isEmpty(xsdnoDto.getUser_id())) {
            throw new CartierNotFoundException(errCode, "用户名不为空！");
        }

        FindOperatInfoDto<SubmitInfoDto> findOperatInfoDto = approveSaleRepostService.qryUnApprove(xsdnoDto);
        return new Result<FindOperatInfoDto<SubmitInfoDto>>(sucCode, sucMsg, findOperatInfoDto);
    }

    @PostMapping("/qryApprove")
    @ResponseBody
    public Result<FindOperatInfoDto<SubmitInfoDto>> qryApprove(@RequestBody XsdnoDto xsdnoDto) {
        if (StringUtils.isEmpty(xsdnoDto.getUser_id())) {
            throw new CartierNotFoundException(errCode, "用户名不为空！");
        }

        FindOperatInfoDto<SubmitInfoDto> findOperatInfoDto = approveSaleRepostService.qryApprove(xsdnoDto);
        return new Result<FindOperatInfoDto<SubmitInfoDto>>(sucCode, sucMsg, findOperatInfoDto);
    }

    @PostMapping("/updApprove")
    @ResponseBody
    public Result<String> updApprove(@RequestBody ApprovSubmit approvSubmit) {

        approveSaleRepostService.updSellDetail(approvSubmit);
        return new Result<String>(sucCode, sucMsg, "");
    }

    @PostMapping("/qryApprover")
    @ResponseBody
    public Result<List<ApprovesDto>> qryApprover(@RequestBody XsdnoDto xsdnoDto) {
        if (StringUtils.isEmpty(xsdnoDto.getUser_id())) {
            throw new CartierNotFoundException(errCode, "用户名不为空！");
        }

        List<ApprovesDto> list = approveSaleRepostService.qryApprover(xsdnoDto);
        return new Result<List<ApprovesDto>>(sucCode, sucMsg, list);
    }
}