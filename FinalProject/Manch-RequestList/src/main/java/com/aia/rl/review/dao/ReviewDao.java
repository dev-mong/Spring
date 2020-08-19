package com.aia.rl.review.dao;

import java.util.List;
import java.util.Map;

import com.aia.rl.model.RequestReg;
import com.aia.rl.review.model.Review;

public interface ReviewDao {

	//리뷰 등록
	public int insertReview(Review review);

	//리뷰 작성 자 리스트 출력
	public Review selectReview(String nick);
	
	//리뷰 리스트 출력 
	public List<RequestReg> selectReview(Map<String, Object> map);
	
	//리뷰 리스트 개수 
	public int totalReview(String mNick);
	
	

}
