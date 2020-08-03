package com.aia.opmvc.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IdCheckController {
	
	
	@RequestMapping("/member/idCheck")
	public String idCheck(@RequestParam("uid") String uid) {
	
		return "member/idCheck";
	}

}
