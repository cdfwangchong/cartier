package com.ctg.cartier.pojo.dto.base;

import lombok.Data;

import java.util.List;

@Data
public class FindOperatInfoDto<T> {
    private int pageNumber;

    private int pageSize;

    private List<T> list;

    private long totalPage;

    private long totalRow;

}
