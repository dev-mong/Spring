package com.aia.rl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;
import com.aia.rl.model.RequestView;
import com.aia.rl.review.dao.ReviewDao;

@Service
public class RequestListService {

	private RequestDao dao;
	

	@Autowired
	private SqlSessionTemplate template;

	public RequestView requestList(String mLat, String mLon, int mRadius, String type, int page, String searchText,
			String searchType) {

		dao = template.getMapper(RequestDao.class);

		final int REQUEST_COUNT_PAGE = 10; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = 0; // 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행


		// 출력 할 리스트
		List<RequestReg> result = null;

		// 검색 조건
		Map<String, Object> searchMap = new HashMap<String, Object>();
		if (searchType != null && !searchType.isEmpty()) {
			searchMap.put("searchType", searchType);
		}
		if (searchText != null && !searchText.isEmpty()) {
			searchMap.put("search", searchText);
		}
		searchMap.put("startRow", startRow);
		searchMap.put("count", REQUEST_COUNT_PAGE);
		
		

		// 회원 위도 경도 정보
		Map<String, Object> distanceMap = new HashMap<String, Object>();
		if (mLat != null && !mLat.isEmpty()) {
			distanceMap.put("mLat", mLat);
		}
		if (mLon != null && !mLon.isEmpty()) {
			distanceMap.put("mLon", mLon);
		}
		distanceMap.put("mRadius", mRadius);
		distanceMap.put("type",type);
		
		
		// 회원인지 비회원인지 알려주기
		if (mLat.equals("0") && mLon.equals("0")) { // 비회원 일 때
			result = dao.selectAllList(searchMap); //전체 게시물 출력
			listTotalCnt = dao.allTotalCount(); // 전체 게시물 개수
			
			//검색어가 있을 때 전체 리스트 검색 
			if(searchText !=null && !searchText.isEmpty()) {
				result = dao.selectRequestList(searchMap);
				listTotalCnt = dao.totalCount(searchMap);
			}

		} else { // 회원 일 떄

				result = dao.loginDistanceAll(distanceMap,searchMap); //회원 거리순 게시물 출력 - type
				listTotalCnt = dao.loginTotalCount(distanceMap,searchMap);// 거리 계산한 게시물 수
				
				//검색어가 있을 때 전체 리스트 검색 
				if(searchText !=null && !searchText.isEmpty()) {
					result = dao.searchDistance(distanceMap,searchMap);
					listTotalCnt = dao.searchDistanceTotalCount(distanceMap,searchMap);
				}
			
		}
		
		
		
		for(int i=0;i<result.size();i++) {
			double distance = result.get(i).getDistance();
			double test = Math.round(distance*100);
			int calDistance = (int)(test) * 10;
			result.get(i).setCalDistance(calDistance);
		}
		

		RequestView resultView = new RequestView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, result,
				startRow);
		
		
		return resultView;

	}

}
