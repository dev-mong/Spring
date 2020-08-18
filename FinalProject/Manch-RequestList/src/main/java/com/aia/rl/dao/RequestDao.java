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
	public List<RequestReg> selectAllList(Map<String, Object> searchMap);
	
	
	// 전체 게시물 타입 별로 리스트  - 검색어 없을 떄  / 비회원 일 때 전체 게시물 개수 
	public int allTotalCount();

	
	
	
	
	
	
	
	//로그인 한 사용자 거리 계산 된 전체 게시글 리스트 
	public List<RequestReg> loginDistanceAll(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );
	
	//로그인 한 사용자 최신 순으로 리스트 출력
	public List<RequestReg> loginDateAll(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );
	
	//거리 계산 된 전체 게시물 개수 
	public int loginTotalCount();

	//거리순으로 검색
	public List<RequestReg> searchDistance(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );

	//시간순으로 검색
	public List<RequestReg> searchDate(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );


	
	
	
	
}
