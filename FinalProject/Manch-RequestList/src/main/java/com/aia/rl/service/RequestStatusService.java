package com.aia.rl.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;

@Service
public class RequestStatusService {

	
	private RequestDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	
	public int requestStatusEdit(int idx) {
		
		dao=template.getMapper(RequestDao.class);
		
		int reqStatus = 0;
		
		
		return dao.statusEdit(idx,reqStatus);
	}

}
