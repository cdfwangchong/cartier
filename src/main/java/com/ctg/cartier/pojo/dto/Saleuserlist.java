package com.ctg.cartier.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * SALEUSERLIST
 * @author 
 */
@ApiModel(value="com.ctg.cartier.pojo.dto.Saleuserlist卡地亚销售日报用户表")
@Data
public class Saleuserlist implements Serializable {
    /**
     * 用户ID（企业微信回传的）
     */
    @ApiModelProperty(value="用户ID（企业微信回传的）")
    private String userid;

    /**
     * 用户名称（企业微信回传的）
     */
    @ApiModelProperty(value="用户名称（企业微信回传的）")
    private String username;

    /**
     * 所属部门
     */
    @ApiModelProperty(value="所属部门")
    private String department;

    /**
     * 职务
     */
    @ApiModelProperty(value="职务")
    private String position;

    /**
     * 电话号码
     */
    @ApiModelProperty(value="电话号码")
    private String telNum;

    /**
     * 所属品牌
     */
    @ApiModelProperty(value="所属品牌")
    private String brand;

    /**
     * 是否审批人
     */
    @ApiModelProperty(value="是否审批人")
    private String isApprover;

    /**
     * 审批品牌
     */
    @ApiModelProperty(value="审批品牌")
    private String approvBrand;

    /**
     * 发送时间
     */
    @ApiModelProperty(value="发送时间")
    private Date fsdate;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String gender;

    private static final long serialVersionUID = 1L;
}