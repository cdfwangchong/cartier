package com.ctg.cartier.service.impl;

import com.ctg.cartier.dao.SaleuserlistDao;
import com.ctg.cartier.pojo.dto.Saleuserlist;
import com.ctg.cartier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@author wangchong
*2019
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	SaleuserlistDao saleuserlistDao;
	@Override
	public int insert(Saleuserlist record) {
		return saleuserlistDao.insert(record);
	}
	@Override
	public int insertSelective(Saleuserlist record) {
		return saleuserlistDao.insertSelective(record);
	}
	@Override
	public List<Saleuserlist> selectByPrimaryKey(String userid) {
		return saleuserlistDao.selectByPrimaryKey(userid);
	}
}
