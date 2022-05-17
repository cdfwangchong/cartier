package com.ctg.cartier.service.impl;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.ctg.cartier.dao.ApproveSaleReportDao;

import com.ctg.cartier.dao.SaleuserlistDao;
import com.ctg.cartier.pojo.dto.*;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;
import com.ctg.cartier.service.ApproveSaleRepostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.ctg.cartier.pojo.until.Constant.errCode;
import static com.ctg.cartier.pojo.until.Constant.errMsg;

@Service
@Slf4j
public class ApproveSaleRepostServiceImpl implements ApproveSaleRepostService {
    @Autowired
    ApproveSaleReportDao approveSaleReportDao;

    @Autowired
    SaleuserlistDao saleuserlistDao;
    @Override
    public FindOperatInfoDto<SubmitInfoDto> qryUnApprove(XsdnoDto xsdnoDto) {
        Map param = xsdnoDto.toMap();
        int pageSize = xsdnoDto.getPageSize();
        int pageNum = xsdnoDto.getPageNum();
        long totalPage;

        param.put("type","Y");
        param.put("approv_result","X");
        FindOperatInfoDto<SubmitInfoDto> pager = new FindOperatInfoDto<SubmitInfoDto>();
        List<Salereporthead> list;
        List<SubmitInfoDto> shlist=new ArrayList<SubmitInfoDto>();
        try {
            list = approveSaleReportDao.qryApprove(param);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        for (int i = 0; i <list.size() ; i++) {
            Salereporthead salereporthead= list.get(i);
            SubmitInfoDto submitInfoDto = new SubmitInfoDto();
            submitInfoDto.setSubmiter_num(salereporthead.getOperator());
            submitInfoDto.setSubmiter_date(salereporthead.getFsdate());
            submitInfoDto.setSubmiter_name(salereporthead.getOperatorName());
            submitInfoDto.setXsdno(salereporthead.getXsdno());
            shlist.add(submitInfoDto);
        }
        pager.setList(shlist);

        long totalRow = 0;
        try {
            totalRow = approveSaleReportDao.Count(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算总页数
        if (totalRow%pageSize >0) {
            totalPage = totalRow/pageSize+1;
        }else {
            totalPage = totalRow/pageSize;
        }
        pager.setTotalPage(totalPage);
        pager.setTotalRow(totalRow);
        pager.setPageSize(pageSize);
        pager.setPageNumber(pageNum);
        return pager;
    }

    @Override
    public FindOperatInfoDto<SubmitInfoDto> qryApprove(XsdnoDto xsdnoDto) {
        Map param = xsdnoDto.toMap();
        int pageSize = xsdnoDto.getPageSize();
        int pageNum = xsdnoDto.getPageNum();
        long totalPage;

        param.put("type","Y");
        param.put("approv_result","NY");
        FindOperatInfoDto<SubmitInfoDto> pager = new FindOperatInfoDto<SubmitInfoDto>();
        List<Salereporthead> list;
        List<SubmitInfoDto> shlist=new ArrayList<SubmitInfoDto>();
        try {
            list = approveSaleReportDao.qryApprove(param);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        for (int i = 0; i <list.size() ; i++) {
            Salereporthead salereporthead= list.get(i);
            SubmitInfoDto submitInfoDto = new SubmitInfoDto();
            submitInfoDto.setSubmiter_num(salereporthead.getOperator());
            submitInfoDto.setSubmiter_date(salereporthead.getFsdate());
            submitInfoDto.setSubmiter_name(salereporthead.getOperatorName());
            submitInfoDto.setXsdno(salereporthead.getXsdno());
            shlist.add(submitInfoDto);
        }
        pager.setList(shlist);

        long totalRow = 0;
        try {
            totalRow = approveSaleReportDao.Count(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算总页数
        if (totalRow%pageSize >0) {
            totalPage = totalRow/pageSize+1;
        }else {
            totalPage = totalRow/pageSize;
        }
        pager.setTotalPage(totalPage);
        pager.setTotalRow(totalRow);
        pager.setPageSize(pageSize);
        pager.setPageNumber(pageNum);
        return pager;
    }

    @Override
    public void updSellDetail(ApprovSubmit approvSubmit) {

        Salereporthead salereporthead = new Salereporthead();
        salereporthead.setXsdno(approvSubmit.getXsdno());
        salereporthead.setApprover(approvSubmit.getSubmiter_id());
        salereporthead.setApprovResult(approvSubmit.getFlag());
        salereporthead.setApprovRemark(approvSubmit.getRemark());
        Date date = new Date();
        salereporthead.setApprovTime(date);
        try {
            approveSaleReportDao.updateByPrimaryKeySelective(salereporthead);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
    }

    @Override
    public List<ApprovesDto>  qryApprover(XsdnoDto xsdnoDto) {
        String userid = xsdnoDto.getUser_id();
        List<ApprovesDto> list;
        try {
            list = saleuserlistDao.selectByApprove(userid);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        return list;
    }
}
