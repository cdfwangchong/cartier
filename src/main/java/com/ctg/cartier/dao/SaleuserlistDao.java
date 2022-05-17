package com.ctg.cartier.dao;

import com.ctg.cartier.pojo.dto.ApprovesDto;
import com.ctg.cartier.pojo.dto.Saleuserlist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleuserlistDao {
    int deleteByPrimaryKey(String userid);

    int insert(Saleuserlist record);

    int insertSelective(Saleuserlist record);

    List<Saleuserlist> selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(Saleuserlist record);

    int updateByPrimaryKey(Saleuserlist record);

    List<ApprovesDto> selectByApprove(String userid);
}