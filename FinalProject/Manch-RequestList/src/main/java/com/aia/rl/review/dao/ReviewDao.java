package com.aia.rl.review.dao;


import java.util.List;
import java.util.Map;

import com.aia.rl.review.model.Review;

public interface ReviewDao {

	//리뷰 등록
	public int insertReview(Review review);

	//리뷰 작성 여부 확인 
	public Review selectReview(Map<String, Object> map);
	
	
	//작성 한 리뷰의 평점 출력 
	public int selectReg(String mNick);

	public List<Review> reviewList(String mNick);
	
	
	
	//리뷰 리스트 개수 
	//public int totalReview(String mNick);

	

}
