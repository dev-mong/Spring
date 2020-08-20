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

	//작성 된 리뷰 등록 하는 것
	@PostMapping
	public int reviewReg(Review review) {
		System.out.println("작성한 리뷰 >>" + review.toString());
		return regService.reviewReg(review);
	}

	// 리뷰 상대방 선택 
	@PostMapping("/{reviewWriter}")
	public List<Review> nickCheck(@PathVariable("reviewWriter") String reviewWriter) {
		return checkServie.selectReceiver(reviewWriter);

	}

	// 매칭 상대 정해지면 리뷰 기본 값 저장하기 
	@GetMapping("/{mNick}")
	public ReviewView reviewList(@PathVariable("mNick") String mNick, @RequestParam("page") int page) {
		return listService.reviewAvg(mNick, page);
	}

}
