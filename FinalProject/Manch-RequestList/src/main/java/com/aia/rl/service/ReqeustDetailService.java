package com.aia.rl.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;

@Service
public class ReqeustDetailService {

	private RequestDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public RequestReg detailRequest(int idx) {

		dao = template.getMapper(RequestDao.class);

		return dao.selectIdx(idx);
	}
}
