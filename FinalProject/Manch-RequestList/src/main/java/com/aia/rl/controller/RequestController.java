package com.aia.rl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.model.ReqeustRegReq;
import com.aia.rl.model.RequestReg;
import com.aia.rl.service.RequestListService;
import com.aia.rl.service.RequestRegService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired
	private RequestRegService regService;

	@Autowired
	private RequestListService listService;

	// 요청 게시물 등록
	@PostMapping
	public int requestReg(ReqeustRegReq requestRegReq, HttpServletRequest request) {

		return regService.requestReg(requestRegReq, request);
	}

	// 요청 글 리스트 출력

	@GetMapping
	public List<RequestReg> requestList() {

		return listService.requestList();
	}

}
