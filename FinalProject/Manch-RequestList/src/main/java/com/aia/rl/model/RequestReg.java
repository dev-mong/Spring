package com.aia.rl.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestReg {
	
	private int reqIdx;
	private int reqWriter;
	private String reqTitle;
	private int reqHelper;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date reqDateTime;
	private String reqAddr;
	private String reqContents;
	private String reqLatitude;
	private String reqLongitude;
	private int reqCount;
	private int reqStatus;
	private String reqImg;
	
	
	
	
	public RequestReg(String reqTitle, String reqAddr, String reqContents,String reqLatitude, String reqLongitude) {
		this.reqTitle=reqTitle;
		this.reqAddr=reqAddr;
		this.reqContents=reqContents;
		this.reqLatitude=reqLatitude;
		this.reqLongitude=reqLongitude;
	}
	
	
	
	
	
	public int getReqIdx() {
		return reqIdx;
	}





	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
	}





	public int getReqWriter() {
		return reqWriter;
	}





	public void setReqWriter(int reqWriter) {
		this.reqWriter = reqWriter;
	}





	public String getReqTitle() {
		return reqTitle;
	}





	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}





	public int getReqHelper() {
		return reqHelper;
	}





	public void setReqHelper(int reqHelper) {
		this.reqHelper = reqHelper;
	}





	public Date getReqDateTime() {
		return reqDateTime;
	}





	public void setReqDateTime(Date reqDateTime) {
		this.reqDateTime = reqDateTime;
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





	public int getReqCount() {
		return reqCount;
	}





	public void setReqCount(int reqCount) {
		this.reqCount = reqCount;
	}





	public int getReqStatus() {
		return reqStatus;
	}





	public void setReqStatus(int reqStatus) {
		this.reqStatus = reqStatus;
	}





	public String getReqImg() {
		return reqImg;
	}





	public void setReqImg(String reqImg) {
		this.reqImg = reqImg;
	}





	@JsonFormat(pattern="mm-dd HH:mm", timezone = "Asia/Seoul")
	public java.util.Date getToDate(){
		return new java.util.Date(reqDateTime.getTime());
	}
	
	
}
