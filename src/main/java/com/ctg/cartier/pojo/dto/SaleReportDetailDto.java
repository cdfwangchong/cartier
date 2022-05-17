package com.ctg.cartier.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleReportDetailDto {
    private String goods_cshh;

    private BigDecimal goods_count;

    private String independent_code;

    private String goods_id;

}
