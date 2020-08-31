package com.aia.rl.review.dao;


import java.util.List;
import java.util.Map;

import com.aia.rl.review.model.Review;

public interface ReviewDao {

	//리뷰 등록
	public int updateReview(Review review);

	
	//상대방이 여러명일 때 리뷰 상대방 선택 
	public List<Review> selectReceiver(String reviewWriter);
	 
	
	
	//작성 한 리뷰의 평점 출력 
	public int selectAvg(String mNick);

	
	//회원이 작성 한 리뷰 
	public List<Review> reviewList(Map<String, Object> map);
	
	
	
	//리뷰 리스트 개수 
	public int totalReview(String mNick);
	
	
	//리뷰 작성 여부 확인 
	public List<Review> selectReqIdx(int idx);
	
	
	//리뷰 상태 등록
	public int insertStatus(Review review);
	
	//게시글 삭제 시 리뷰 여부
	public List<Review> selectReqReview(int idx);

	//받은 리뷰 수
	public int receiveView(String mNick);

	
	//회원 리뷰 평점 등록하기
	public int updateMember(Map<String, Object> member);

	

}
