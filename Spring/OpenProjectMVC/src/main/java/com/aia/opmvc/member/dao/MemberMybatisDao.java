package com.aia.opmvc.member.dao;

import com.aia.opmvc.member.model.LoginInfo;
import com.aia.opmvc.member.model.LoginRequest;
import com.aia.opmvc.member.model.Member;

public interface MemberMybatisDao {

	public int insertMember (Member member);

	public LoginInfo selectByIdPw(LoginRequest loginRequest);
	
	
}
