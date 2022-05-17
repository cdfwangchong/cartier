package com.ctg.cartier.controller;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.ctg.cartier.pojo.dto.SaleReportDto;
import com.ctg.cartier.pojo.dto.SaleReportHeadDto;
import com.ctg.cartier.pojo.dto.XsdnoDto;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;
import com.ctg.cartier.pojo.until.Result;
import com.ctg.cartier.service.SaleReportService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.ctg.cartier.pojo.until.Constant.*;

@Api(tags = "销售日报")
@CrossOrigin
@RequestMapping("/cdfg")
@RestController
@Slf4j
public class SaleReportController {
    @Autowired
    SaleReportService saleReportService;

    @PostMapping("/qryXsdno")
    @ResponseBody
    public Result<SaleReportHeadDto> qryXsdno(@RequestBody XsdnoDto xsdnoDto) {
        if(StringUtils.isEmpty(xsdnoDto.getUser_id()) ){
            throw new CartierNotFoundException(errCode,"用户名不为空！");
        }
        if(StringUtils.isEmpty(xsdnoDto.getXsdno()) ){
            throw new CartierNotFoundException(errCode,"提货单号不能为空");
        }
        return new Result<SaleReportHeadDto>(sucCode,sucMsg,saleReportService.qryXsdno(xsdnoDto));
    }

    @PostMapping("/insertSellDetail")
    @ResponseBody
    public Result<String> insertSellDetail (@RequestBody SaleReportHeadDto saleReportHeadDto) {
        Map param = saleReportService.insertSellDetail(saleReportHeadDto);
        return new Result<String>(sucCode,sucMsg,"");
    }

    @PostMapping("/updSellDetail")
    @ResponseBody
    public Result<String> updSellDetail (@RequestBody SaleReportHeadDto saleReportHeadDto) {
        Map param  = saleReportService.updSellDetail(saleReportHeadDto);
        return new Result<String>(sucCode,sucMsg,"");
    }

    @PostMapping("/qrySellDetail")
    @ResponseBody
    public Result<SaleReportHeadDto> qrySellDetail (@RequestBody XsdnoDto xsdnoDto) {
        if(StringUtils.isEmpty(xsdnoDto.getUser_id()) ){
            throw new CartierNotFoundException(errCode,"用户名不为空！");
        }
        if(StringUtils.isEmpty(xsdnoDto.getXsdno()) ){
            throw new CartierNotFoundException(errCode,"提货单号不能为空");
        }
        SaleReportHeadDto saleReportHeadDto  = saleReportService.qrySellDetail(xsdnoDto);
        return new Result<SaleReportHeadDto>(sucCode,sucMsg,saleReportHeadDto);
    }

    @PostMapping("/qryPendingSellList")
    @ResponseBody
    public Result<FindOperatInfoDto<SaleReportDto>> qryPendingSellList (@RequestBody XsdnoDto xsdnoDto) {
        if(StringUtils.isEmpty(xsdnoDto.getUser_id()) ){
            throw new CartierNotFoundException(errCode,"用户名不为空！");
        }
        FindOperatInfoDto<SaleReportDto> findOperatInfoDto =saleReportService.qryPendingSellList(xsdnoDto);
        return new Result<FindOperatInfoDto<SaleReportDto>>(sucCode,sucMsg,findOperatInfoDto);
    }

    @PostMapping("/qryFailSellList")
    @ResponseBody
    public Result<FindOperatInfoDto<SaleReportDto>>  qryFailSellList (@RequestBody XsdnoDto xsdnoDto) {
        if(StringUtils.isEmpty(xsdnoDto.getUser_id()) ){
            throw new CartierNotFoundException(errCode,"用户名不为空！");
        }
        FindOperatInfoDto<SaleReportDto> findOperatInfoDto = saleReportService.qryFailSellList(xsdnoDto);
        return new Result<FindOperatInfoDto<SaleReportDto>>(sucCode,sucMsg,findOperatInfoDto);
    }

    @PostMapping("/qrySuccessSellList")
    @ResponseBody
    public Result<FindOperatInfoDto<SaleReportDto>> qrySuccessSellList (@RequestBody XsdnoDto xsdnoDto) {
        if(StringUtils.isEmpty(xsdnoDto.getUser_id()) ){
            throw new CartierNotFoundException(errCode,"用户名不为空！");
        }
        FindOperatInfoDto<SaleReportDto> findOperatInfoDto =saleReportService.qrySuccessSellList(xsdnoDto);
        return new Result<FindOperatInfoDto<SaleReportDto>>(sucCode,sucMsg,findOperatInfoDto);
    }
}
