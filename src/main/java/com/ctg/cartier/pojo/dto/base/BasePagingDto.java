package com.ctg.cartier.pojo.dto.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20200614
 * To change this template use File | Settings | File Templates.
 */
@Data
public class BasePagingDto extends AbstractCriteria implements Serializable {
    private int pageSize = 10;
    private int pageNum = 1;
}