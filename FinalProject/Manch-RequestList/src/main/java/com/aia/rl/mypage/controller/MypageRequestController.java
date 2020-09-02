package com.aia.rl.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.model.RequestView;
import com.aia.rl.mypage.service.MyListService;

@RestController
@RequestMapping("/mypage")
public class MypageRequestController {
	
	
	@Autowired
	private MyListService listService;
	
	//요청 글 리스트 타입 별로 출력  .. 
	@CrossOrigin
	@GetMapping("/{mNick}")
	public RequestView myList(@PathVariable("mNick") String mNick, 
			@RequestParam ("type") String type,
			@RequestParam("page") int page){
		
		System.out.println(listService.myList(mNick,type,page));
		
		return listService.myList(mNick,type,page);
	}
	
}
