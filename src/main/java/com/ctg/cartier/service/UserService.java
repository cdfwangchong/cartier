package com.ctg.cartier.service;

import com.ctg.cartier.pojo.dto.Saleuserlist;

import java.util.List;
import java.util.Map;

public interface UserService {
    int insert(Saleuserlist record);

    int insertSelective(Saleuserlist record);

    List<Saleuserlist> selectByPrimaryKey(String userid);

}
