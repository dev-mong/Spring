package com.aia.rl.review.service;

import java.util.HashMap;
import java.util.Map;

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
	

	public Review reviewCheck(String mNick, int idx) {
	
		dao = template.getMapper(ReviewDao.class);
	
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mNick",mNick);
		map.put("idx",idx);
		
		return dao.selectReview(map);
	}

}
