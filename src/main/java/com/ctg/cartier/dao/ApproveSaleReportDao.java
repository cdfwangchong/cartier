package com.ctg.cartier.dao;

import com.ctg.cartier.pojo.dto.Salereporthead;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ApproveSaleReportDao {
    List<Salereporthead> qryApprove(Map map);

    long Count(Map param);

    int updateByPrimaryKeySelective (Salereporthead salereporthead);
}
