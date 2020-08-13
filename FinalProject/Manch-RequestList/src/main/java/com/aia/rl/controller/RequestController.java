package com.aia.rl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.model.ReqeustRegReq;
import com.aia.rl.model.RequestEdit;
import com.aia.rl.model.RequestReg;
import com.aia.rl.service.ReqeustDetailService;
import com.aia.rl.service.ReqeustEditService;
import com.aia.rl.service.RequestListService;
import com.aia.rl.service.RequestRegService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Autowired
	private RequestRegService regService;

	@Autowired
	private RequestListService listService;
	
	@Autowired
	private ReqeustDetailService detailService;
	
	@Autowired
	private ReqeustEditService editService;

	
	
	// 요청 게시물 등록
	@PostMapping
	public int requestReg(ReqeustRegReq requestRegReq, HttpServletRequest request) {
		return regService.requestReg(requestRegReq, request);
	}
	
	
	// 요청 글 리스트 출력
	@GetMapping
	public List<RequestReg> requestList(@RequestParam ("mLat") String mLat, @RequestParam ("mLon") String mLon,@RequestParam ("mRadius") int mRadius) {
	

		return listService.requestList(mLat,mLon,mRadius);
	}
	
	//요청 글 상세 정보 출력
	@GetMapping("/{idx}")
	public RequestReg requestDetail(@PathVariable ("idx") int idx){
		
		return detailService.requestDetail(idx);
	}
	
	//요청 글 수정
	@PostMapping("/{idx}")
	public int requestEdit(@PathVariable ("idx") int reqIdx, RequestEdit edit,HttpServletRequest request) {
		
		edit.setReqIdx(reqIdx);
		
		return editService.requestEdit(edit,request);
	}
	
	

}
