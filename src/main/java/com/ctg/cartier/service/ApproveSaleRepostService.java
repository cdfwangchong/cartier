package com.ctg.cartier.service;

import com.ctg.cartier.pojo.dto.*;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;

import java.util.List;
import java.util.Map;

public interface ApproveSaleRepostService {
    FindOperatInfoDto<SubmitInfoDto> qryUnApprove(XsdnoDto xsdnoDto);

    FindOperatInfoDto<SubmitInfoDto> qryApprove(XsdnoDto xsdnoDto);

    void updSellDetail (ApprovSubmit approvSubmit);

    List<ApprovesDto> qryApprover (XsdnoDto xsdnoDto);
}
