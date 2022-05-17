package com.ctg.cartier.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SaleReportDto {

    private  String xsdno ;

    private  String billno;

    private  BigDecimal goods_total;

    private String custno;

    private String user_id;

    private String user_name;

    private Date sale_date;

    private  BigDecimal sale_amount;

    private String goods_cshh;

    private BigDecimal goods_count;

    private String goods_id;

    private String independent_code;

    private String sale_name;

    private Date sale_time;

    private String remark;

    private String result;

}
