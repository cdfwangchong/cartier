package com.ctg.cartier.pojo.dto;

import com.ctg.cartier.pojo.dto.base.BasePagingDto;
import lombok.Data;

@Data
public class XsdnoDto extends BasePagingDto {
    private String xsdno;

    private String user_id;
}
