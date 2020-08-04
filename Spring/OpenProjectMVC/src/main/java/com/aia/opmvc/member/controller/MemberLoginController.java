package com.aia.opmvc.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.opmvc.member.model.LoginRequest;
import com.aia.opmvc.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/loginForm")
public class MemberLoginController {

	
	@Autowired
	MemberLoginService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(LoginRequest loginRequest ,Model model,
			HttpSession session,HttpServletResponse response,
			@RequestHeader ("referer") String header) {
		
		String message= service.login(loginRequest, session,response,header);
		
		model.addAttribute("message",message);
		
		return "member/login";
	}
	
}
