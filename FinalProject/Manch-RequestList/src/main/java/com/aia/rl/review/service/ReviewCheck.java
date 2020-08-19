package com.aia.rl.review.service;

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
	

	public Review reviewCheck(String nick) {
	
		dao = template.getMapper(ReviewDao.class);
		return dao.selectReview(nick);
	}

}
