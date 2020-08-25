package com.aia.rl.service;


import java.util.ArrayList;
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
		int reqIdx = 0;
		
		
		for(int i=0;i<review.size();i++) {
			
		//요청글 리스트와 리뷰에 요청글 리스트가 같을 때 리뷰 작성 가능한 사람들을 뽑는다	
		if(review.get(i).getReqIdx() == idx) {	
			//로그인 한 사용자가 글쓴이 일 때 
				if(mNick.equals(review.get(i).getWriter())) {
					
					reqIdx = review.get(i).getReqIdx(); //요청글 번호
					status = review.get(i).getStatus();
					writer = review.get(i).getWriter();
					
					reg.setReviewStatus(status);
					reg.setReviewWriter(writer);
					reg.setRevReqIdx(reqIdx);
				}
			
			}	
		}
		
		return reg;
	}
	
	
}
