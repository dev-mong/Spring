package com.aia.rl.review.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;
import com.aia.rl.review.model.ReviewView;

@Service
public class ReviewCheck {
	
	
	private ReviewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//리뷰를 작성할 상대방 선택 
	public ReviewView selectReceiver(String reviewWriter, int reqIdx, int page) {
	
		dao = template.getMapper(ReviewDao.class);
		
		final int REQUEST_COUNT_PAGE = 3; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = dao.receiverTotal(reviewWriter,reqIdx);// 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reqIdx",reqIdx);
		map.put("reviewWriter", reviewWriter);
		map.put("startRow", startRow);
		map.put("count", REQUEST_COUNT_PAGE);
		
		List<Review> review = dao.selectReceiver(map);
		
		for(int i=0;i<review.size();i++) {
			System.out.println(review.get(i).getStatus());
		}
		
		
		ReviewView result = new ReviewView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, review, startRow);
		
		
		
		
		
		
		
		return result;
	}

}
