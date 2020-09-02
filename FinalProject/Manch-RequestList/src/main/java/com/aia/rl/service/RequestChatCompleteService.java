package com.aia.rl.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestChat;
import com.aia.rl.model.RequestView;
import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;

@Service
public class RequestChatCompleteService {
	
	
	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

//	public List<RequestChat> cahtComplete(int idx,int page) { //idx -> 게시글 번호 
		public RequestView cahtComplete(int idx,int page) { //idx -> 게시글 번호 
		
		dao=template.getMapper(RequestDao.class);
		
		final int REQUEST_COUNT_PAGE = 3; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = dao.totalChat(idx);// 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행
		
		System.out.println("매칭 상대 현재 페이지 >> "+page);
		System.out.println("매칭 상대 시작행 >> "+startRow);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx",idx);
		map.put("startRow", startRow);
		map.put("count", REQUEST_COUNT_PAGE);
		
		
		List<RequestChat> chatList = dao.selectChatRoom(map);
		
		RequestView chatView = new RequestView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, startRow);
		chatView.setRequestChat(chatList);
		
		System.out.println(chatView.toString());
		
		return chatView; //채팅 요청 한 요청자 검색 
	}
	
	
	
	
}
