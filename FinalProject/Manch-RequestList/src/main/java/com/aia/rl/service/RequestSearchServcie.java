package com.aia.rl.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;
import com.aia.rl.model.RequestView;

@Service
public class RequestSearchServcie {

	private RequestDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public RequestView requestSearch(String search,String type,int page) {
		
		dao=template.getMapper(RequestDao.class);
		
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		if(type !=null && !type.isEmpty()) {
			searchMap.put("type",type);
		}
		if(search !=null && !search.isEmpty()) {
			searchMap.put("search",search);
		}

		
		final int REQUEST_COUNT_PAGE = 4; //한 페이지 당 표현 할 리스트 수
		int listTotalCnt = dao.totalCount(searchMap); //전체 리스트 개수
		int currentPageNum=page; //현재 페이지
		
		int startRow=0;
		List<RequestReg> requestReg = null; // 요청 리스트 
		RequestView  requestRegView = null; // 요청 리스트 
		
		if (listTotalCnt > 0) {
			startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행 

			searchMap.put("startRow",startRow);
			searchMap.put("count", REQUEST_COUNT_PAGE);
			
			requestReg = dao.selectRequestList(searchMap);
			
			
			
			
			
			
		} else {
			currentPageNum = 0;
			requestReg = Collections.emptyList();
		}
		

		requestRegView = new RequestView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, requestReg, startRow);

		
		
		return requestRegView;
	}
	
	

	
}
