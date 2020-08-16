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

	private RequestDao requestDao;
	
	private ReviewDao reviewDao;

	@Autowired
	private SqlSessionTemplate template;

	public RequestReg requestDetail(int idx,HttpServletRequest request) {
		
		requestDao = template.getMapper(RequestDao.class);
		
		String uri = "/upload";
		
		
		// 시스템의 실제(절대) 경로
		String realPath = request.getSession().getServletContext().getRealPath(uri);
		
		RequestReg reg = requestDao.selectIdx(idx);
		
		reg.setRealPath(realPath);
		
		return reg;
	}
	
	
}
