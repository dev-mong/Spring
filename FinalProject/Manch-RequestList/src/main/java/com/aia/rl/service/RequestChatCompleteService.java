package com.aia.rl.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;

@Service
public class RequestChatCompleteService {
	
	
	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public Object cahtComplete(String mNick) {
		
		dao=template.getMapper(RequestDao.class);
		
		//String helper = dao.selectChat(mNick);
		
		return null;
	}
	
	
	
	
}
