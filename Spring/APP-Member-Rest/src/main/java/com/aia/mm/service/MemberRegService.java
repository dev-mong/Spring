package com.aia.mm.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mm.dao.MemberDao;
import com.aia.mm.model.Member;
import com.aia.mm.model.MemberRegRequest;

@Service
public class MemberRegService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int regMember(MemberRegRequest regRequest) {
		
		Member member = regRequest.toMember();
		
		int reulst = dao.insertMember(member);
		
		return 0;
	}
	
	
	
}
