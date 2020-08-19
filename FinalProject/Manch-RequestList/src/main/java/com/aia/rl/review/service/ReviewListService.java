package com.aia.rl.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.model.RequestReg;
import com.aia.rl.model.RequestRegView;
import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;
import com.aia.rl.review.model.ReviewView;

@Service

public class ReviewListService {
	
	
	private ReviewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public ReviewView reviewList(String mNick,int page) {
	
		dao = template.getMapper(ReviewDao.class);
		
		
		final int REQUEST_COUNT_PAGE = 4; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = 0; // 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mNick",mNick);
		map.put("startRow", startRow);
		map.put("count", REQUEST_COUNT_PAGE);
		
		
		List<RequestReg> result = dao.selectReview(map); //전체 게시물 출력

		listTotalCnt = dao.totalReview(mNick);
		
		ReviewView resultView = new ReviewView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, result, startRow);

		
		return resultView;
		
		
	}
	
}
