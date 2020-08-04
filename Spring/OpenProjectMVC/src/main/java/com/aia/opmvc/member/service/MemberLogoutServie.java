package com.aia.opmvc.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberLogoutServie {

	public void logout(HttpSession session) {

		//세션 종료
		session.invalidate();
		
	}

}
