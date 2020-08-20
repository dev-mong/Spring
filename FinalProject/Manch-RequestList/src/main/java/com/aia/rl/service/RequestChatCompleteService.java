package com.aia.rl.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestChat;

@Service
public class RequestChatCompleteService {
	
	
	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public List<RequestChat> cahtComplete(int idx) {
		
		dao=template.getMapper(RequestDao.class);
		
		
		return dao.selectChatRoom(idx); //채팅 요청 한 요청자 검색 
	}
	
	
	
	
}
