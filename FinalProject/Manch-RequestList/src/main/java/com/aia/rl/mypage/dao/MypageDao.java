package com.aia.rl.mypage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aia.rl.model.RequestReg;

public interface MypageDao {
	
	
	//마이페이지 요청글/대여글 리스트 출력
	List<RequestReg> selectMyList(Map<String, Object> map);
	
	//회원이 작성 한 전체 리스트 개수
	int allTotalCount (@Param("mNick") String mNick, @Param("type") String type);



}
