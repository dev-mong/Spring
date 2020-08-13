package com.aia.rl.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestEdit {

	private int reqIdx;
	private String reqTitle;
	private String reqContents;
	private String oldImg;
	private MultipartFile reqImg;

	public RequestEdit() {
	}

	public RequestEdit(int reqIdx, String reqTitle, String reqContents, String oldImg, MultipartFile reqImg) {
		this.reqIdx = reqIdx;
		this.reqTitle = reqTitle;
		this.reqContents = reqContents;
		this.oldImg = oldImg;
		this.reqImg = reqImg;
	}

	public int getReqIdx() {
		return reqIdx;
	}

	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}

	public String getReqContents() {
		return reqContents;
	}

	public void setReqContents(String reqContents) {
		this.reqContents = reqContents;
	}

	public String getOldImg() {
		return oldImg;
	}

	public void setOldImg(String oldImg) {
		this.oldImg = oldImg;
	}

	public MultipartFile getReqImg() {
		return reqImg;
	}

	public void setReqImg(MultipartFile reqImg) {
		this.reqImg = reqImg;
	}

	public RequestReg toRequestReg() {
		return new RequestReg(reqIdx, reqTitle, reqContents, oldImg.length() > 0 ? oldImg : null, null);
	}

}