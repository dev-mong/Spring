package com.aia.opmvc.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller 
@RequestMapping("/member/regForm")
public class MemberRegController {


	@RequestMapping(method=RequestMethod.GET)
	public String regForm() {
		
		return "member/regForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String reg(Model model, HttpServletRequest request) {
		
		
		
		return "member/reg";
	}
	
	
}
