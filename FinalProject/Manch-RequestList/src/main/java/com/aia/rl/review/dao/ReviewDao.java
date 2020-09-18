package com.aia.rl.review.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aia.rl.review.model.Review;

public interface ReviewDao {

	//리뷰 등록
	public int updateReview(Review review);

	
	//리뷰 상대 선택 시 전체 리스트 수 
	public int receiverTotal(@Param("reviewWriter")String reviewWriter,@Param("reqIdx") int reqIdx);
	 
	
	//상대방이 여러명일 때 리뷰 상대방 선택 
	public List<Review> selectReceiver(Map<String, Object> map);
	
	
	//작성 한 리뷰의 평점 출력 
	public int selectAvg(String mNick);

	
	//회원이 작성 한 리뷰 - 마이페이지 
	public List<Review> reviewList(Map<String, Object> map);
	
	
	
	//리뷰 리스트 개수 
	public int totalReview(@Param ("mNick") String mNick,@Param ("status") int status);
	
	
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
