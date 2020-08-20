package com.aia.rl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.model.RequestChat;
import com.aia.rl.service.RequestChatCompleteService;
import com.aia.rl.service.ReuqestHelperRegService;

@RestController
@RequestMapping("/chat")
public class RequestChatController {

	@Autowired
	private RequestChatCompleteService completeService;
	
	@Autowired
	private ReuqestHelperRegService helperRegService;
	
	// 매칭 상대 선택
	@GetMapping("/complete/{idx}")
	public List<RequestChat> chatComplete(@PathVariable("idx") int idx) {
		return completeService.cahtComplete(idx);
	}
	
	// 헬퍼 등록
	@GetMapping("/{idx}")
	public int helperReg(@PathVariable("idx") int idx, @RequestParam("helper") String helper,
			@RequestParam("writer") String writer,
			@RequestParam("mNick") String mNick,
			@RequestParam("reqIdx") int reqIdx
			) {
		
		return helperRegService.helperReg(helper, idx,writer,reqIdx,mNick);
	}
	
	
	
}
