package com.ctg.cartier.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ManageSaleReportDto {
    private String brand_name;

    private String brand_code;

    private String sale_name;

    private String billno;

    private String xsdno;

    private Date sale_date;

    private String goods_cshh;

    private String goods_id;

    private BigDecimal goods_count;

    private String custno;

    private String independent_code;

}
