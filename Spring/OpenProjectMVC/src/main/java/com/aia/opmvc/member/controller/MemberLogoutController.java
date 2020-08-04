package com.aia.opmvc.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.opmvc.member.service.MemberLogoutServie;

@Controller
public class MemberLogoutController {

	@Autowired
	MemberLogoutServie service;
	
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		
		service.logout(session);
		
		return "member/logout";
	}
	
}
