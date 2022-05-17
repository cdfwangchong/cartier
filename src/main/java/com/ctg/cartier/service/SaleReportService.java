package com.ctg.cartier.service;

import com.ctg.cartier.pojo.dto.SaleReportDto;
import com.ctg.cartier.pojo.dto.SaleReportHeadDto;
import com.ctg.cartier.pojo.dto.XsdnoDto;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;

import java.util.List;
import java.util.Map;

public interface SaleReportService {
    SaleReportHeadDto qryXsdno(XsdnoDto xsdnoDto);

    Map insertSellDetail (SaleReportHeadDto saleReportHeadDto);

    Map updSellDetail (SaleReportHeadDto saleReportHeadDto);

    SaleReportHeadDto qrySellDetail (XsdnoDto xsdnoDto);

    FindOperatInfoDto<SaleReportDto> qryPendingSellList(XsdnoDto xsdnoDto);

    FindOperatInfoDto<SaleReportDto> qryFailSellList(XsdnoDto xsdnoDto);

    FindOperatInfoDto<SaleReportDto> qrySuccessSellList(XsdnoDto xsdnoDto);
}
