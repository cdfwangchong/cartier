package com.ctg.cartier.dao;

import com.ctg.cartier.pojo.dto.SaleReportDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SaleReportDao {
    Map qryXsdno(Map map);

    Map insertSellDetail(Map map);

    Map updSellDetail (Map map);

    List<SaleReportDto> paging (Map map);

    long Count(Map param);

    Map qrySaleReportInfo(Map map);
}
