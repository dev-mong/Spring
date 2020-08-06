package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.model.Member;

public interface MemberDaoInterface {
	
	public Member selectByIdpw(String uid, String pw); 
	
	//idx 기반으로 검색한 화면의 정보 반환
	public Member selectById(int idx);
	
	public int insertMember(Member member);
	
	//전체 게시물의 개수 : 검색 포함 
	public int totalCount(Map search);
	
	//전체 게시물 List<Member>로 반환 
	public List<Member> selectList(Map search);
	
}
