package com.aia.rl.review.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	//리뷰 등록 
	@PostMapping
	public int reviewReg(Review review) {
		System.out.println(review);
		return regService.reviewReg(review);
	}
	
	//리뷰 작성자 확인
	@PostMapping("/{idx}")
	public Review nickCheck(@PathVariable ("idx") int idx,
			@RequestParam("mNick") String mNick) {
		return checkServie.reviewCheck(mNick,idx);
	}
	
	@GetMapping("/{mNick}")
	public ReviewView reviewList(@PathVariable ("mNick") String mNick,@RequestParam("page") int page) {
		return listService.reviewAvg(mNick,page);
	}
	
	

	
}
