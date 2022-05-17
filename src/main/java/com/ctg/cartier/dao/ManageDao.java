package com.ctg.cartier.dao;

import com.ctg.cartier.pojo.dto.ManageSaleReportDto;
import com.ctg.cartier.pojo.dto.SaleReportDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ManageDao {
    List<ManageSaleReportDto> qrySaleReport (Map map);

    long Count(Map param);
}
