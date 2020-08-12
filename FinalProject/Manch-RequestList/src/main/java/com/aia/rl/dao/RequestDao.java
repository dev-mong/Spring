package com.aia.rl.dao;

import java.util.List;

import com.aia.rl.model.RequestReg;

public interface RequestDao {

	//요청 게시글 등록
	public int insertRequest(RequestReg requestReg);

	//요청 게시글 리스트 검색
	public List<RequestReg> selectAllList();

	//요청 게시글 상세 정보 
	public RequestReg selectIdx(int idx);
	
}
