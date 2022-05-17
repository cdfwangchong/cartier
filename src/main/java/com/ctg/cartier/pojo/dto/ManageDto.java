package com.ctg.cartier.pojo.dto;

import com.ctg.cartier.pojo.dto.base.BasePagingDto;
import lombok.Data;

import java.util.Date;
@Data
public class ManageDto extends BasePagingDto {
    private Date start_time;

    private Date end_time;

    private String brand_name;

    private String brand_code;

    private String sale_name;

    private String xsdno;


}
