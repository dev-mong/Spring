package com.aia.rl.model;

import org.springframework.web.multipart.MultipartFile;

public class ReqeustRegReq {

	private String reqWriter;
	private String reqTitle;
	private String reqAddr;
	private String reqContents;
	private MultipartFile reqImg;
	private String reqLatitude;
	private String reqLongitude;

	public ReqeustRegReq() {
	}

	public String getReqWriter() {
		return reqWriter;
	}

	public void setReqWriter(String reqWriter) {
		this.reqWriter = reqWriter;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}

	public String getReqAddr() {
		return reqAddr;
	}

	public void setReqAddr(String reqAddr) {
		this.reqAddr = reqAddr;
	}

	public String getReqContents() {
		return reqContents;
	}

	public void setReqContents(String reqContents) {
		this.reqContents = reqContents;
	}

	public MultipartFile getReqImg() {
		return reqImg;
	}

	public void setReqImg(MultipartFile reqImg) {
		this.reqImg = reqImg;
	}

	public String getReqLatitude() {
		return reqLatitude;
	}

	public void setReqLatitude(String reqLatitude) {
		this.reqLatitude = reqLatitude;
	}

	public String getReqLongitude() {
		return reqLongitude;
	}

	public void setReqLongitude(String reqLongitude) {
		this.reqLongitude = reqLongitude;
	}

	public RequestReg toRequestReg() {
		return new RequestReg(reqWriter,reqTitle, reqAddr, reqContents, reqLatitude, reqLongitude);
	}

	@Override
	public String toString() {
		return "ReqeustRegReq [reqWriter=" + reqWriter + ", reqTitle=" + reqTitle + ", reqAddr=" + reqAddr
				+ ", reqContents=" + reqContents + ", reqImg=" + reqImg + ", reqLatitude=" + reqLatitude
				+ ", reqLongitude=" + reqLongitude + "]";
	}

	
}
