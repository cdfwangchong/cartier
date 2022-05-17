package com.ctg.cartier.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * SALEREPORTDETAIL
 * @author 
 */
@ApiModel(value="com.ctg.cartier.pojo.dto.Salereportdetail卡地亚销售日报表体")
@Data
public class Salereportdetail implements Serializable {
    /**
     * 提货单号
     */
    @ApiModelProperty(value="提货单号")
    private String xsdno;

    /**
     * 销售单号
     */
    @ApiModelProperty(value="销售单号")
    private String billno;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value="品牌名称")
    private String brandName;

    /**
     * 品牌编码
     */
    @ApiModelProperty(value="品牌编码")
    private String brandCode;

    /**
     * 厂商货号
     */
    @ApiModelProperty(value="厂商货号")
    private String goodsCshh;

    /**
     * 商品编码
     */
    @ApiModelProperty(value="商品编码")
    private String goodsId;

    /**
     * 销售数量
     */
    @ApiModelProperty(value="销售数量")
    private BigDecimal goodsCount;

    /**
     * 独立编码
     */
    @ApiModelProperty(value="独立编码")
    private String independentCode;

    /**
     * 发送时间
     */
    @ApiModelProperty(value="发送时间")
    private Date fsdate;

    private static final long serialVersionUID = 1L;
}