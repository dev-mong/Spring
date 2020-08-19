package com.aia.rl.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestReg {

	private int reqIdx;
	private String reqWriter;
	private String reqTitle;
	private String reqHelper;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp reqDateTime;
	private String reqAddr;
	private String reqContents;
	private String reqLatitude;
	private String reqLongitude;
	private int reqCount;
	private int reqStatus;
	private String reqImg;
	private double distance; //디비와 이름 동일 
	
	private int calDistance;
	
	public RequestReg() {
	}

	public RequestReg(int reqIdx, String reqWriter, String reqTitle, String reqHelper, Timestamp reqDateTime,
			String reqAddr, String reqContents, String reqLatitude, String reqLongitude, int reqCount, int reqStatus,
			String reqImg) {
		this.reqIdx = reqIdx;
		this.reqWriter = reqWriter;
		this.reqTitle = reqTitle;
		this.reqHelper = reqHelper;
		this.reqDateTime = reqDateTime;
		this.reqAddr = reqAddr;
		this.reqContents = reqContents;
		this.reqLatitude = reqLatitude;
		this.reqLongitude = reqLongitude;
		this.reqCount = reqCount;
		this.reqStatus = reqStatus;
		this.reqImg = reqImg;
	}
	
	//등록
	public RequestReg(String reqWriter, String reqTitle, String reqAddr, String reqContents, String reqLatitude,
			String reqLongitude) {

		this.reqWriter = reqWriter;
		this.reqTitle = reqTitle;
		this.reqAddr = reqAddr;
		this.reqContents = reqContents;
		this.reqLatitude = reqLatitude;
		this.reqLongitude = reqLongitude;

		// this(0, reqWriter, reqTitle, 0, null, reqAddr, reqContents, reqLatitude,
		// reqLongitude, 0, 0, null);

	}
	
	//수정
//	public RequestReg(int reqIdx, String reqTitle, String reqContents, String reqImg, Timestamp reqDateTime) {
		public RequestReg(int reqIdx, String reqWriter,String reqTitle, String reqContents, String reqImg) {
		this.reqIdx = reqIdx;
		this.reqWriter=reqWriter;
		this.reqTitle = reqTitle;
		this.reqContents = reqContents;
		this.reqImg = reqImg;
		//this.reqDateTime = reqDateTime;
	}

	public int getReqIdx() {
		return reqIdx;
	}

	public void setReqIdx(int reqIdx) {
		this.reqIdx = reqIdx;
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

	public String getReqHelper() {
		return reqHelper;
	}

	public void setReqHelper(String reqHelper) {
		this.reqHelper = reqHelper;
	}

	public Timestamp getReqDateTime() {
		return reqDateTime;
	}

	public void setReqDateTime(Timestamp reqDateTime) {
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

	public double getDistance() {
		return distance;
	}

	public double setDistance(double distance) {
		return this.distance = distance;
	}


	
	
	public int getCalDistance() {
		return calDistance;
	}

	public void setCalDistance(int calDistance) {
		this.calDistance = calDistance;
	}

	@Override
	public String toString() {
		return "RequestReg [reqIdx=" + reqIdx + ", reqWriter=" + reqWriter + ", reqTitle=" + reqTitle + ", reqHelper="
				+ reqHelper + ", reqDateTime=" + reqDateTime + ", reqAddr=" + reqAddr + ", reqContents=" + reqContents
				+ ", reqLatitude=" + reqLatitude + ", reqLongitude=" + reqLongitude + ", reqCount=" + reqCount
				+ ", reqStatus=" + reqStatus + ", reqImg=" + reqImg + ", distance=" + distance + "]";

	}
}
