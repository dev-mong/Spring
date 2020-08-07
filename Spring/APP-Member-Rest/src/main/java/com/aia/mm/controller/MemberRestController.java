package com.aia.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mm.model.Member;
import com.aia.mm.model.MemberRegRequest;
import com.aia.mm.service.MemberListService;

@RestController
@RequestMapping("/members")
public class MemberRestController {

	@Autowired
	private MemberListService listService;
	
	//회원의 리스트 : Json 으로 응답 
	@GetMapping 		//Get 	|	/members
	public List<Member> getMemberList(){
		return listService.getMemberList();
	}
	
	// 회원 등록
	@PostMapping 		//Post 	|	/members
	public int reg(MemberRegRequest regRequest) {
		return 0;
	}
	
	// 한 명의 회원 정보 보기
	@GetMapping("/{idx}")
//	public Member getMember() {
//		return null;
//	}
	
	// 한 명의 회원 정보 수정
	@PutMapping("/{idx}") 	//Put | /members/{idx}
	public int edit() {
		return 0;
	}
	
	// 한 명의 회원 정보 삭제 
	public int delete() {
		return 0;
	}
	
}
