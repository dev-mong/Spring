package com.aia.rl.review.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;

@Service
public class ReviewCheck {
	
	
	private ReviewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//리뷰를 작성할 상대방 선택 
	public List<Review> selectReceiver(String reviewWriter) {
	
		dao = template.getMapper(ReviewDao.class);
		
		List<Review> review = dao.selectReceiver(reviewWriter);
		
		return review;
	}

}
