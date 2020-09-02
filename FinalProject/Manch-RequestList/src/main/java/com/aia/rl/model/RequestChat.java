package com.aia.rl.model;



public class RequestChat {

	private int chatIdx;
	private String chatName;
	private int requestIdx;
	private String helper;
	private String writer;
	
	//멤버
	private String mImg;
	private int avg;

	public RequestChat() {
	}

	public RequestChat(int chatIdx, String chatName, int requestIdx, String helper, String writer, String mImg,
			int avg) {
		this.chatIdx = chatIdx;
		this.chatName = chatName;
		this.requestIdx = requestIdx;
		this.helper = helper;
		this.writer = writer;
		this.mImg = mImg;
		this.avg = avg;
	}

	public int getChatIdx() {
		return chatIdx;
	}

	public void setChatIdx(int chatIdx) {
		this.chatIdx = chatIdx;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public int getRequestIdx() {
		return requestIdx;
	}

	public void setRequestIdx(int requestIdx) {
		this.requestIdx = requestIdx;
	}

	public String getHelper() {
		return helper;
	}

	public void setHelper(String helper) {
		this.helper = helper;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getmImg() {
		return mImg;
	}

	public void setmImg(String mImg) {
		this.mImg = mImg;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "RequestChat [chatIdx=" + chatIdx + ", chatName=" + chatName + ", requestIdx=" + requestIdx + ", helper="
				+ helper + ", writer=" + writer + ", mImg=" + mImg + ", avg=" + avg + "]";
	}

	
	
	
	
	

}
