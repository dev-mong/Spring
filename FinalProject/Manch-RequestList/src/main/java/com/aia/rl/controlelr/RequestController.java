package com.aia.rl.controlelr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.model.ReqeustRegReq;
import com.aia.rl.servcie.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RequestService regService;
	
	
	//요청 게시물 등록
	@PostMapping
	public int requestReg(ReqeustRegReq requestRegReq, HttpServletRequest request) {
		
		
		return regService.requestReg(requestRegReq, request);
	}
	
}
