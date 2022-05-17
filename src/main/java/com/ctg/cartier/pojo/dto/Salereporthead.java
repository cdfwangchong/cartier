package com.ctg.cartier.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * SALEREPORTHEAD
 * @author 
 */
@ApiModel(value="com.ctg.cartier.pojo.dto.Salereporthead卡地亚销售日报表头")
@Data
public class Salereporthead implements Serializable {
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
     * 销售数量
     */
    @ApiModelProperty(value="销售数量")
    private BigDecimal goodsTotal;

    /**
     * 顾客编码
     */
    @ApiModelProperty(value="顾客编码")
    private String custno;

    /**
     * 操作员ID
     */
    @ApiModelProperty(value="操作员ID")
    private String operator;

    /**
     * 操作员姓名
     */
    @ApiModelProperty(value="操作员姓名")
    private String operatorName;

    /**
     * 销售时间
     */
    @ApiModelProperty(value="销售时间")
    private Date saleTime;

    /**
     * 发送时间
     */
    @ApiModelProperty(value="发送时间")
    private Date fsdate;

    /**
     * 是否审批
     */
    @ApiModelProperty(value="是否审批")
    private String isApprov;

    /**
     * 审批时间
     */
    @ApiModelProperty(value="审批时间")
    private Date approvTime;

    /**
     * 审批人ID
     */
    @ApiModelProperty(value="审批人ID")
    private String approver;

    /**
     * 审批结果（Y:通过；N：不通过）

     */
    @ApiModelProperty(value="审批结果（Y:通过；N：不通过）")
    private String approvResult;

    /**
     * 审批意见
     */
    @ApiModelProperty(value="审批意见")
    private String approvRemark;

    /**
     * 销售金额
     */
    @ApiModelProperty(value="销售金额")
    private BigDecimal amount;

    private static final long serialVersionUID = 1L;
}