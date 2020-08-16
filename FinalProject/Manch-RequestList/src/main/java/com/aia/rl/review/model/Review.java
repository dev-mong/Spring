package com.aia.rl.review.model;

public class Review {
	
	private int reqIdx;
	private String receiver;
	private String writer;
	private String text;
	private int avg;
	
	
	public Review() {
	}

	public Review(int reqIdx, String receiver, String writer, String text, int avg) {
		this.reqIdx = reqIdx;
		this.receiver = receiver;
		this.writer = writer;
		this.text = text;
		this.avg = avg;
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

	@Override
	public String toString() {
		return "Review [reqIdx=" + reqIdx + ", receiver=" + receiver + ", writer=" + writer + ", text=" + text
				+ ", avg=" + avg + "]";
	}

	
	
	
	
}
