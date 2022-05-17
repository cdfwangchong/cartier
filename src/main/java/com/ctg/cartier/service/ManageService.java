package com.ctg.cartier.service;

import com.ctg.cartier.pojo.dto.ManageDto;
import com.ctg.cartier.pojo.dto.ManageSaleReportDto;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;

public interface ManageService {

    FindOperatInfoDto<ManageSaleReportDto> qrySaleReport(ManageDto manageDto);
}
