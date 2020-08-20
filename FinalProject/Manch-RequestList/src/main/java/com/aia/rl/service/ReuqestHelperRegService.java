package com.aia.rl.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;

@Service
public class ReuqestHelperRegService {

	private RequestDao dao;
	
	private ReviewDao rdao;
	
	@Autowired
	private SqlSessionTemplate template;

	
	public int helperReg(String helper, int idx, String writer, int reqIdx, String mNick) {
		
		
		dao=template.getMapper(RequestDao.class);
		rdao=template.getMapper(ReviewDao.class);
		
		
		Map<String, Object> helperMap = new HashMap<String, Object>();
		helperMap.put("helper", helper);
		helperMap.put("idx", idx);
		
		
		// 리뷰 테이블 업데이트 - 매칭 두 대상에 대해 리뷰를 쓸 수 있도록 설정
		
		  int status = 0;
		  int reviewReg = 0;
		  
		  
		  Review review = null;
		  
			  
			  review = new Review(reqIdx, writer, helper, status);
			  reviewReg = rdao.insertStatus(review);
			  review = new Review(reqIdx, helper, writer, status);
			  reviewReg = rdao.insertStatus(review);
		  
		
		  
		  System.out.println("리뷰가 등록 됬는지 여부 >>>"+reviewReg);
		
		return 	dao.helperReg(helperMap);
	}

	
	
}
