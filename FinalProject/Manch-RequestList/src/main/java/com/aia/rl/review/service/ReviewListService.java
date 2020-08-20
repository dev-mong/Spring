package com.aia.rl.review.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.model.RequestRegView;
import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;
import com.aia.rl.review.model.ReviewView;

@Service

public class ReviewListService {
	
	
	private ReviewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public ReviewView reviewAvg(String mNick,int page) {
	
		dao = template.getMapper(ReviewDao.class);
		
		final int REQUEST_COUNT_PAGE = 4; // 한 페이지 당 표현 할 리스트 수
		int listTotalCnt = dao.totalReview(mNick); // 전체 리스트 개수
		int currentPageNum = page; // 현재 페이지
		int startRow = (currentPageNum - 1) * REQUEST_COUNT_PAGE; // 시작 행
		
		List<Review> list = dao.reviewList(mNick); // 로그인 한 사용자 가 작성한 전체 리뷰 
		
		int avg = dao.selectReg(mNick); //회원 평점
		
		ReviewView result = new ReviewView(listTotalCnt, REQUEST_COUNT_PAGE, currentPageNum, list, startRow, avg);
		
		return result;
		
	}
	
}
