package com.aia.rl.review.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rl.review.model.Review;
import com.aia.rl.review.service.ReviewRegServcie;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private ReviewRegServcie regService;

	//리뷰 등록 
	@PostMapping
	public int reviewReg(Review review) {
		System.out.println(review);
		return regService.reviewReg(review);
	}
	

	
}
