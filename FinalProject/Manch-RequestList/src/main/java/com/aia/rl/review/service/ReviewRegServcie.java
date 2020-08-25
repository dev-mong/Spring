package com.aia.rl.review.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;

@Service
public class ReviewRegServcie {
	
	private ReviewDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	public int reviewReg(Review review) {
		
		dao=template.getMapper(ReviewDao.class);
		
		review.setStatus(1);
		
		int result = dao.updateReview(review);
		
		return result;
	}
	
	
}
