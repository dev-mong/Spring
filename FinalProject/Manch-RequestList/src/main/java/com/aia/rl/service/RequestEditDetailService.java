package com.aia.rl.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;

@Service
public class RequestEditDetailService {

	private RequestDao dao;

	@Autowired
	private SqlSessionTemplate template;
	
	public RequestReg editDetail(int idx) {
		

		dao = template.getMapper(RequestDao.class);
		
		RequestReg reg = dao.selectIdx(idx);
		
		return reg;
	}
	
	

}
