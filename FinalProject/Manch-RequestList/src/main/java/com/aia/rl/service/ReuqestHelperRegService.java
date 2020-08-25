package com.aia.rl.service;

import java.util.HashMap;
import java.util.List;
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

	
	public int helperReg(String helper, int idx, String writer, String mNick) {
		
		
		dao=template.getMapper(RequestDao.class);
		rdao=template.getMapper(ReviewDao.class);
		
		
		Map<String, Object> helperMap = new HashMap<String, Object>();
		helperMap.put("helper", helper);
		helperMap.put("idx", idx);
		
		// 리뷰 테이블 업데이트 - 매칭 두 대상에 대해 리뷰를 쓸 수 있도록 설정
		  int status = 0;
		  int reviewReg = 0;
		  Review review = null;
		  
		  List<Review> reviewStatus = rdao.selectReqIdx(idx); //리뷰 검색
		  for(int i=0;i<reviewStatus.size();i++) {
			  //이미 등록 된 리뷰 작성자와 받는 사람 중  helper가 존재 한다면 
			  if(reviewStatus.get(i).getReceiver().equals(helper) || reviewStatus.get(i).getWriter().equals(helper)) {
				  reviewReg = -1;
			  }
		  }
	
		  if(reviewReg == 0) { // 동일 한 매칭 상대가 없을 때 리뷰를 등록한다
			  review = new Review(helper,idx, writer, status);
			  reviewReg = rdao.insertStatus(review);
			  review = new Review(writer,idx, helper, status);
			  reviewReg = rdao.insertStatus(review);
			  reviewReg = dao.helperReg(helperMap);//리뷰 등록 여부 확인 
			  reviewReg = 2;
		  }
		  
		  System.out.println("매칭 상대 확인 하기 >>>"+reviewReg);
		  
		  return reviewReg;
	}

	
	
}
