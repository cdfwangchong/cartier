package com.ctg.cartier.pojo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SubmitInfoDto {
    private String xsdno;

    private String submiter_name;

    private String Submiter_num;

    private Date submiter_date;
}
