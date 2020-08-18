package com.aia.rl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aia.rl.model.RequestReg;

public interface RequestDao {

	//요청 게시글 등록
	public int insertRequest(RequestReg requestReg);


	//요청 게시글 상세 정보 
	public RequestReg selectIdx(int idx);
	
	//요청 게시글 수정
	public int editRequest(RequestReg requestReg);

	//요청 게시글 삭제
	public int deleteRequest(int idx);

	//요청 글 취소 상태 변경
	public int statusEdit(@Param("idx") int idx, @Param("reqStatus") int reqStatus);
	
	
	
	/*
	 * //제목 검색, 닉네임 검색 public List<RequestReg> selectSearch(@Param("search") String
	 * search);
	 */



	
	
	
	
	
	//검색 한 전체 게시물 리스트 
	public List<RequestReg> selectRequestList(Map<String, Object> searchMap);

	//검색 후 요청 게시글 전체 검색 
	public int totalCount(Map<String, Object> searchMap);
		
	
	//요청 게시글 리스트 검색
	public List<RequestReg> selectAllList();
	
	
	// 전체 게시물 타입 별로 리스트  - 검색어 없을 떄 
	public int boardTotalCount();


	
	
	
}
