package com.aia.rl.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;
import com.aia.rl.review.dao.ReviewDao;

@Service
public class ReqeustDetailService {

	private RequestDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public RequestReg requestDetail(int idx,int count) {
		
		dao = template.getMapper(RequestDao.class);
		
		count++;
		//조회수 증가
		dao.updateCount(idx,count);
		
		RequestReg reg = dao.selectIdx(idx);
		
		return reg;
	}
	
	
}
