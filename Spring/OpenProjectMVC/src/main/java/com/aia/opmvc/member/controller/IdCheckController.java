package com.aia.opmvc.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.opmvc.member.service.IdCheckService;


@Controller
public class IdCheckController {
	
	@Autowired
	IdCheckService service;
	
	@RequestMapping("/member/idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("uid") String uid) {
		return service.check(uid);
	}

}
