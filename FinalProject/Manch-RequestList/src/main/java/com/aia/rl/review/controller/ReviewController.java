package com.aia.rl.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.review.model.Review;
import com.aia.rl.review.model.ReviewView;
import com.aia.rl.review.service.ReviewCheck;
import com.aia.rl.review.service.ReviewListService;
import com.aia.rl.review.service.ReviewRegServcie;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewRegServcie regService;

	@Autowired
	private ReviewCheck checkServie;

	@Autowired
	private ReviewListService listService;

	//정해진 매칭 상대에 대해서 리뷰 등록 
	@CrossOrigin
	@PostMapping
	public int reviewReg(Review review) {
		return regService.reviewReg(review);
	}

	// 리뷰 상대방 선택 
	@CrossOrigin
	@PostMapping("/{reviewWriter}")
	public ReviewView nickCheck(@PathVariable("reviewWriter") String reviewWriter,
			@RequestParam("reqIdx") int reqIdx,
			@RequestParam("page") int page){
		return checkServie.selectReceiver(reviewWriter,reqIdx,page);

	}

	// 마이페이지 리뷰 출력
	@CrossOrigin
	@GetMapping("/{mNick}")
	public ReviewView reviewList(@PathVariable("mNick") String mNick, @RequestParam("page") int page,
			@RequestParam("status") int status) {
		return listService.reviewMyPage(mNick, page,status);
	}

}
