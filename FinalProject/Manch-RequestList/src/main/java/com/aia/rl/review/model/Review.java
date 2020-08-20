package com.aia.rl.review.model;

import java.util.List;

import com.aia.rl.model.RequestReg;

public class Review {

	private int reviewIdx;
	private int reqIdx;
	private String receiver;
	private String writer;
	private String text;
	private int avg;
	private int status;

	private List<RequestReg> reqList;

	public Review() {
	}

	public Review(int reviewIdx, String receiver, String writer, int status) {
		this.reviewIdx = reviewIdx;
		this.receiver = receiver;
		this.writer = writer;
		this.status = status;
	}

	public Review(int reviewIdx, int reqIdx, String receiver, String writer, String text, int avg, int status,
			List<RequestReg> reqList) {
		this.reviewIdx = reviewIdx;
		this.reqIdx = reqIdx;
		this.receiver = receiver;
		this.writer = writer;
		this.text = text;
		this.avg = avg;
		this.status = status;
		this.reqList = reqList;
	}

	public int getReviewIdx() {
		return reviewIdx;
	}

	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
	}

	public int getReqIdx() {
		return reqIdx;
	}

	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<RequestReg> getReqList() {
		return reqList;
	}

	public void setReqList(List<RequestReg> reqList) {
		this.reqList = reqList;
	}

	@Override
	public String toString() {
		return "Review [reviewIdx=" + reviewIdx + ", reqIdx=" + reqIdx + ", receiver=" + receiver + ", writer=" + writer
				+ ", text=" + text + ", avg=" + avg + ", status=" + status + ", reqList=" + reqList + "]";
	}

}
