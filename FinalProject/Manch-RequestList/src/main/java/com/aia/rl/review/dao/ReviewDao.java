package com.aia.rl.review.dao;

import com.aia.rl.review.model.Review;

public interface ReviewDao {

	//리뷰 등록
	public int insertReview(Review review);

	//리뷰 작성 자 리스트 출력
	public Review selectReview(String nick);
	

}
