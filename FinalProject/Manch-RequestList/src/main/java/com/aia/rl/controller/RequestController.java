package com.aia.rl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.model.ReqeustRegReq;
import com.aia.rl.model.RequestEdit;
import com.aia.rl.model.RequestReg;
import com.aia.rl.review.service.ReviewCheck;
import com.aia.rl.service.ReqeustDeleteService;
import com.aia.rl.service.ReqeustDetailService;
import com.aia.rl.service.ReqeustEditService;
import com.aia.rl.service.RequestListService;
import com.aia.rl.service.RequestRegService;
import com.aia.rl.service.RequestStatusService;

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

	@Autowired
	private ReqeustDeleteService deleteService;
	
	@Autowired
	private RequestStatusService statusService;
	

	
	// 요청 게시물 등록
	@PostMapping
	public int requestReg(ReqeustRegReq requestRegReq,HttpServletRequest request) {
		
		
		return regService.requestReg(requestRegReq, request);
	}

	//요청 글 게시물 출력 
	@GetMapping
	public List<RequestReg> requestList(
			@RequestParam("mLat") String mLat, 
			@RequestParam("mLon") String mLon,
			@RequestParam("mRadius") int mRadius) {
		
		
		return listService.requestList(mLat, mLon, mRadius);
	}

	// 요청 글 상세 정보 출력
	@GetMapping("/{idx}")
	public RequestReg requestDetail(@PathVariable("idx") int idx,HttpServletRequest request) {

		return detailService.requestDetail(idx,request);
	}
	
	// 요청 글 수정
	@PostMapping("/{idx}")
	public int requestEdit(@PathVariable("idx") int reqIdx, RequestEdit edit, HttpServletRequest request) {
		edit.setReqIdx(reqIdx);
		return editService.requestEdit(edit, request);
	}

	// 요철 글 삭제
	@DeleteMapping("/{idx}")
	public int requestDelete(@PathVariable("idx") int idx, HttpServletRequest request) {
		return deleteService.reqeustDelete(idx, request);
	}
	
	//요청글 상태 정보 변경
	@PutMapping("/{idx}")
	public int reqestStatusEdit(@PathVariable("idx") int idx) {
		
		return statusService.requestStatusEdit(idx);
	}
}
