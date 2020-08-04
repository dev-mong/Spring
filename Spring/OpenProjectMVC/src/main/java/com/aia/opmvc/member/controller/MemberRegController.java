package com.aia.opmvc.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aia.opmvc.member.model.Member;
import com.aia.opmvc.member.service.MemberRegService;



@Controller 
@RequestMapping("/member/regForm")
public class MemberRegController {

	
	@Autowired
	MemberRegService service;

	@RequestMapping(method=RequestMethod.GET)
	public String regForm() {
		
		return "member/regForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String reg(Model model, HttpServletRequest request,Member member,
			@RequestParam("photo") MultipartFile file
			) {
		
		
		member.setUphoto(file);
		
		model.addAttribute("memberCnt",service.memberReg(request,member));
		
		
		return "member/reg";
	}
	
	
}
