package com.ctg.cartier.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApprovSubmit {
    private String xsdno;

    private String submiter_id;

    private String billno;

    private BigDecimal goods_total;

    private String custno;

    private String submiter_name;

    private String flag;

    private String remark;

}
