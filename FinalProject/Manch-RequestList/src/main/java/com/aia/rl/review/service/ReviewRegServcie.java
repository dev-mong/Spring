package com.aia.rl.review.service;

import java.util.HashMap;
import java.util.Map;

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
		
		System.out.println(review.toString());
		
		int result = dao.updateReview(review);
		
		System.out.println(result);
		
		//업데이트 할 리뷰의 평점 출력
		int avg= dao.selectAvg(review.getReceiver());
		
		//회원 리뷰 평점 등록
		Map<String, Object> member = new HashMap<String, Object>();
		member.put("receiver", review.getReceiver());
		member.put("avg", avg);
		
		int update = dao.updateMember(member);
		System.out.println(update);
		
		
		return result;
	}
	
	
}
