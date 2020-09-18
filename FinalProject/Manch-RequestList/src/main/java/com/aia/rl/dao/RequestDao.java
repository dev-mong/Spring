package com.aia.rl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aia.rl.model.RequestChat;
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
	
	//조회수 증가
	public void updateCount(@Param("idx") int idx, @Param("count") int count);

	
	
	
	
	//검색 한 전체 게시물 리스트 
	public List<RequestReg> selectRequestList(Map<String, Object> searchMap);

	
	//검색 후 요청 게시글 전체 검색 
	public int totalCount(Map<String, Object> searchMap);
		
	
	//요청 게시글 리스트 검색
	public List<RequestReg> selectAllList(Map<String, Object> searchMap);
	
	
	// 전체 게시물 타입 별로 리스트  - 검색어 없을 떄  / 비회원 일 때 전체 게시물 개수 
	public int allTotalCount();

	
	
	
	
	
	
	//거리 계산 된 전체 리스트 타입 별로 출력
	public List<RequestReg> loginDistanceAll(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );
	
	//거리 계산 된 전체 게시물 개수 
	public int loginTotalCount(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );

	//타입 별로 거리 계산 한 리스트 검색 데이터 출력 
	public List<RequestReg> searchDistance(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap );

	//타입 별로 거리 계산된 리스트 검색 총 개수 
	public int searchDistanceTotalCount(@Param("distanceMap") Map<String, Object> distanceMap, @Param("searchMap") Map<String, Object> searchMap);

	
	
	
	//채팅 상대 선택 페이징 처리 후 리스트 출력
	public List<RequestChat> selectChatRoom(Map<String, Object> map);


	//채팅 완료 상대 등록
	public int helperReg(Map<String, Object> helperMap);


	//게시글에 대한 전체 채팅 수
	public int totalChat(int idx);

	
	
	
	
	//지도로 보기 게시글 출력
	public List<RequestReg> selectAllMap(Map<String, Object> map);


	public String selectMemberImg(String mNick);


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
