package com.ctg.cartier.service.impl;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.ctg.cartier.dao.ManageDao;
import com.ctg.cartier.pojo.dto.*;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;
import com.ctg.cartier.service.ManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ctg.cartier.pojo.until.Constant.errCode;
import static com.ctg.cartier.pojo.until.Constant.errMsg;

@Service
@Slf4j
public class ManageServiceImpl implements ManageService {
    @Autowired
    ManageDao manageDao;
    @Override
    public FindOperatInfoDto<ManageSaleReportDto> qrySaleReport(ManageDto manageDto) {
        int pageSize = manageDto.getPageSize();
        int pageNum = manageDto.getPageNum();
        long totalPage;
        Map param = new HashMap<String,Object>();
        if (!"".equals(manageDto.getBrand_code())) {
            param.put("brand_code",manageDto.getBrand_code());
        }
        if (!"".equals(manageDto.getBrand_name())) {
            param.put("brand_name",manageDto.getBrand_name());
        }
        if (!"".equals(manageDto.getSale_name())) {
            param.put("sale_name",manageDto.getSale_name());
        }
        if (!"".equals(manageDto.getXsdno())) {
            param.put("xsdno",manageDto.getXsdno());
        }
        param.put("start_time",manageDto.getStart_time());
        param.put("end_time",manageDto.getEnd_time());
        param.put("pageNum",pageNum);
        param.put("pageSize",pageSize);

        FindOperatInfoDto<ManageSaleReportDto> pager = new FindOperatInfoDto<ManageSaleReportDto>();
        List<ManageSaleReportDto> list;
        try {
            list = manageDao.qrySaleReport(param);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        pager.setList(list);

        long totalRow = 0;
        try {
            totalRow = manageDao.Count(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算总页数
        if (totalRow%pageSize >0) {
            totalPage = totalRow/pageSize+1;
        }else {
            totalPage = totalRow/pageSize;
        }
        pager.setTotalPage(totalPage);
        pager.setTotalRow(totalRow);
        pager.setPageSize(pageSize);
        pager.setPageNumber(pageNum);
        return pager;
    }
}
