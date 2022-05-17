package com.ctg.cartier.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SaleReportHeadDto {
    private  String xsdno;

    private  String user_id;

    private  String billno;

    private BigDecimal goods_total;

    private  String custno;

    private  BigDecimal sale_amount;

    private String approver;

    private String user_name;

    private Date sale_time;

    private String sale_name;

    private String result;

    private String remark;

    private List<SaleReportDetailDto> goods_list;

}
