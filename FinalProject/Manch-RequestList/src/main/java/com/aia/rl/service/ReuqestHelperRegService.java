package com.aia.rl.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;

@Service
public class ReuqestHelperRegService {

	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	
	public int helperReg(String helper, int idx) {
		
		
		dao=template.getMapper(RequestDao.class);

		Map<String, Object> helperMap = new HashMap<String, Object>();
		helperMap.put("helper", helper);
		helperMap.put("idx", idx);
		
		return 	dao.helperReg(helperMap);
	}
	
	
	
}
