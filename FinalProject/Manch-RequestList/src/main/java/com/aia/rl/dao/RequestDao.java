package com.aia.rl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aia.rl.model.RequestReg;

public interface RequestDao {

	//요청 게시글 등록
	public int insertRequest(RequestReg requestReg);

	//요청 게시글 리스트 검색
	public List<RequestReg> selectAllList();

	//요청 게시글 상세 정보 
	public RequestReg selectIdx(int idx);
	
	//요청 게시글 수정
	public int editRequest(RequestReg requestReg);

	//요청 게시글 삭제
	public int deleteRequest(int idx);

	//요청 글 취소 상태 변경
	public int statusEdit(@Param("idx") int idx, @Param("reqStatus") int reqStatus);
	
	
	
}
