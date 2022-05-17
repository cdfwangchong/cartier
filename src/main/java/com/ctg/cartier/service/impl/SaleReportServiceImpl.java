package com.ctg.cartier.service.impl;

import cn.ctg.exceptionHandle.CartierNotFoundException;
import com.ctg.cartier.dao.SaleReportDao;
import com.ctg.cartier.pojo.dto.SaleReportDetailDto;
import com.ctg.cartier.pojo.dto.SaleReportDto;
import com.ctg.cartier.pojo.dto.SaleReportHeadDto;
import com.ctg.cartier.pojo.dto.XsdnoDto;
import com.ctg.cartier.pojo.dto.base.FindOperatInfoDto;
import com.ctg.cartier.service.SaleReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ctg.cartier.pojo.until.Constant.errCode;
import static com.ctg.cartier.pojo.until.Constant.errMsg;

@Service
@Slf4j
public class SaleReportServiceImpl implements SaleReportService {
    @Autowired
    SaleReportDao saleReportDao=null;
    @Override
    public SaleReportHeadDto qryXsdno(XsdnoDto xsdnoDto) {
        Map map =xsdnoDto.toMap();
        try {
            saleReportDao.qryXsdno(map);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        String ret_flag = (String) map.get("ret_flag");
        if (!"1002".equals(ret_flag)) {
            String ret_msg = (String) map.get("ret_msg");
            throw new CartierNotFoundException(errCode,ret_msg);
        }
        ArrayList<SaleReportDetailDto> detail = new ArrayList<SaleReportDetailDto>();
        ArrayList<SaleReportDto> rclist = (ArrayList<SaleReportDto> ) map.get("shRc");
        for (int i = 0; i < rclist.size(); i++) {
            SaleReportDto saleReportDto = rclist.get(i);

            SaleReportDetailDto saleReportDetailDto = new SaleReportDetailDto();
            saleReportDetailDto.setGoods_cshh(saleReportDto.getGoods_cshh());
            saleReportDetailDto.setGoods_count(saleReportDto.getGoods_count());
            saleReportDetailDto.setGoods_id(saleReportDto.getGoods_id());
            detail.add(saleReportDetailDto);
        }
        SaleReportHeadDto saleReportHeadDto = new SaleReportHeadDto();
        saleReportHeadDto.setBillno(rclist.get(0).getBillno());
        saleReportHeadDto.setXsdno(rclist.get(0).getXsdno());
        saleReportHeadDto.setGoods_total(rclist.get(0).getGoods_total());
        saleReportHeadDto.setSale_amount(rclist.get(0).getSale_amount());
        saleReportHeadDto.setSale_name(rclist.get(0).getSale_name());
        saleReportHeadDto.setGoods_list(detail);
        return saleReportHeadDto;
    }

    @Override
    public Map insertSellDetail(SaleReportHeadDto saleReportHeadDto) {
        Map param = new HashMap<String,Object>();
        param.put("goodsList",saleReportHeadDto.getGoods_list());
        param.put("xsdno",saleReportHeadDto.getXsdno());
        param.put("billno",saleReportHeadDto.getBillno());
        param.put("userId",saleReportHeadDto.getUser_id());
        param.put("custno",saleReportHeadDto.getCustno());
        param.put("goodsTotal",saleReportHeadDto.getGoods_total());
        param.put("saleAmount",saleReportHeadDto.getSale_amount());
        try {
            saleReportDao.insertSellDetail(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String ret_flag = (String) param.get("ret_flag");
        if (!"1002".equals(ret_flag)) {
            String ret_msg = (String) param.get("ret_msg");
            throw new CartierNotFoundException(errCode,ret_msg);
        }
        return param;
    }

    @Override
    public Map updSellDetail(SaleReportHeadDto saleReportHeadDto) {
        Map param = new HashMap<String,Object>();
        param.put("goodsList",saleReportHeadDto.getGoods_list());
        param.put("xsdno",saleReportHeadDto.getXsdno());
        param.put("billno",saleReportHeadDto.getBillno());
        param.put("userId",saleReportHeadDto.getUser_id());
        param.put("goodsTotal",saleReportHeadDto.getGoods_total());
        param.put("saleAmount",saleReportHeadDto.getSale_amount());
        param.put("approver",saleReportHeadDto.getApprover());
        param.put("custno",saleReportHeadDto.getCustno());
        try {
            saleReportDao.updSellDetail(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String ret_flag = (String) param.get("ret_flag");
        if (!"1002".equals(ret_flag)) {
            String ret_msg = (String) param.get("ret_msg");
            throw new CartierNotFoundException(errCode,ret_msg);
        }
        return param;

    }

    @Override
    public SaleReportHeadDto qrySellDetail(XsdnoDto xsdnoDto) {
        Map map =xsdnoDto.toMap();
        try {
            saleReportDao.qrySaleReportInfo(map);
        } catch (RuntimeException e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        String ret_flag = (String) map.get("ret_flag");
        if (!"1002".equals(ret_flag)) {
            String ret_msg = (String) map.get("ret_msg");
            throw new CartierNotFoundException(errCode,ret_msg);
        }
        ArrayList<SaleReportDetailDto> detail = new ArrayList<SaleReportDetailDto>();
        ArrayList<SaleReportDto> rclist = (ArrayList<SaleReportDto> ) map.get("shRc");
        for (int i = 0; i < rclist.size(); i++) {
            SaleReportDto saleReportDto = rclist.get(i);
            SaleReportDetailDto saleReportDetailDto = new SaleReportDetailDto();
            saleReportDetailDto.setGoods_cshh(saleReportDto.getGoods_cshh());
            saleReportDetailDto.setGoods_count(saleReportDto.getGoods_count());
            saleReportDetailDto.setGoods_id(saleReportDto.getGoods_id());
            saleReportDetailDto.setIndependent_code(saleReportDto.getIndependent_code());
            detail.add(saleReportDetailDto);
        }
        SaleReportHeadDto saleReportHeadDto = new SaleReportHeadDto();
        saleReportHeadDto.setBillno(rclist.get(0).getBillno());
        saleReportHeadDto.setXsdno(rclist.get(0).getXsdno());
        saleReportHeadDto.setGoods_total(rclist.get(0).getGoods_total());
        saleReportHeadDto.setSale_amount(rclist.get(0).getSale_amount());
        saleReportHeadDto.setUser_name(rclist.get(0).getUser_name());
        saleReportHeadDto.setUser_id(rclist.get(0).getUser_id());
        saleReportHeadDto.setCustno(rclist.get(0).getCustno());
        saleReportHeadDto.setSale_time(rclist.get(0).getSale_date());
        saleReportHeadDto.setRemark(rclist.get(0).getRemark());
        saleReportHeadDto.setResult(rclist.get(0).getResult());
        saleReportHeadDto.setGoods_list(detail);
        return saleReportHeadDto;
    }

    @Override
    public FindOperatInfoDto<SaleReportDto> qryPendingSellList(XsdnoDto xsdnoDto) {
        Map param = xsdnoDto.toMap();
        int pageSize = xsdnoDto.getPageSize();
        int pageNum = xsdnoDto.getPageNum();
        long totalPage;
        param.put("approv_result","X");
        FindOperatInfoDto<SaleReportDto> pager = new FindOperatInfoDto<SaleReportDto>();
        List<SaleReportDto> list;
        try {
            list = saleReportDao.paging(param);
        } catch (Exception e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        pager.setList(list);

        long totalRow = 0;
        try {
            totalRow = saleReportDao.Count(param);
        } catch (Exception e) {
            throw new CartierNotFoundException(errCode,errMsg);
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
    public FindOperatInfoDto<SaleReportDto>qryFailSellList(XsdnoDto xsdnoDto) {
        Map param = xsdnoDto.toMap();
        int pageSize = xsdnoDto.getPageSize();
        int pageNum = xsdnoDto.getPageNum();
        long totalPage;

        param.put("approv_result","N");
        FindOperatInfoDto<SaleReportDto> pager = new FindOperatInfoDto<SaleReportDto>();
        List<SaleReportDto> list = saleReportDao.paging(param);
        pager.setList(list);

        long totalRow = 0;
        try {
            totalRow = saleReportDao.Count(param);
        } catch (Exception e) {
            throw new CartierNotFoundException(errCode,errMsg);
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
    public FindOperatInfoDto<SaleReportDto> qrySuccessSellList(XsdnoDto xsdnoDto) {
        Map param = xsdnoDto.toMap();
        int pageSize = xsdnoDto.getPageSize();
        int pageNum = xsdnoDto.getPageNum();
        long totalPage;

        param.put("approv_result","SY");
        FindOperatInfoDto<SaleReportDto> pager = new FindOperatInfoDto<SaleReportDto>();
        List<SaleReportDto> list;
        try {
            list = saleReportDao.paging(param);
        } catch (Exception e) {
            throw new CartierNotFoundException(errCode,errMsg);
        }
        pager.setList(list);
        long totalRow;
        try {
            totalRow = saleReportDao.Count(param);
        } catch (Exception e) {
            throw new CartierNotFoundException(errCode,errMsg);
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
}
