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

public class ReviewListService {
	
	
	private ReviewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public ReviewView reviewMyPage(String mNick,int page,int status) {
	
		dao = template.getMapper(ReviewDao.class);
		
		final int REQUEST_COUNT_PAGE = 4; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = dao.totalReview(mNick,status);// 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mNick",mNick);
		map.put("startRow", startRow);
		map.put("count", REQUEST_COUNT_PAGE);
		map.put("status", status);
		
		List<Review> list = dao.reviewList(map); // 로그인 한 사용자 가 작성한 전체 리뷰 
		
		int reciveCheck = dao.receiveView(mNick);
		int avg = 0;
		if(reciveCheck > 0) {
			avg = dao.selectAvg(mNick); //회원 평점
		}
		
		
		
		System.out.println("리뷰 리스트 현재 페이지 >>"+currentPageNum);
		System.out.println("전체 게시물 >>"+listTotalCnt);
		System.out.println("리뷰 리스트 시작행 >> "+ startRow);
		System.out.println("평점 >>"+avg);
		
		ReviewView result = new ReviewView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, list, startRow, avg);
		
		return result;
		
	}
	
}
