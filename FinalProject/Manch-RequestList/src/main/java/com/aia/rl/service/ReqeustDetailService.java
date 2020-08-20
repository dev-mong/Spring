package com.aia.rl.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;
import com.aia.rl.review.dao.ReviewDao;
import com.aia.rl.review.model.Review;

@Service
public class ReqeustDetailService {

	private RequestDao dao;
	
	private ReviewDao rdao;
	
	@Autowired
	private SqlSessionTemplate template;

	public RequestReg requestDetail(int idx,int count, String mNick) {
		
		dao = template.getMapper(RequestDao.class);
		rdao = template.getMapper(ReviewDao.class);
		
		count++;
		//조회수 증가
		dao.updateCount(idx,count);
		
		RequestReg reg = dao.selectIdx(idx);

		List<Review> review = rdao.selectReqIdx(idx);
		
		
		int status = 0;
		String writer = null;
		
		for(int i=0;i<review.size();i++) {
			
			//로그인 한 사용자가 글쓴이 일 때 
			if(mNick.equals(review.get(i).getWriter())) {
				
				status = review.get(i).getStatus();
				writer = review.get(i).getWriter();
				reg.setReviewStatus(status);
				reg.setReviewWriter(writer);
			}
		}
		
		
		
		
		return reg;
	}
	
	
}
