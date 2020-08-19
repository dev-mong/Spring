package com.aia.rl.model;

import java.util.List;

public class RequestChat {
	
	private int chatIdx;
	private String chatName;
	private int requestIdx;
	private String helper;
	private String writer;
	
	private List<RequestReg> reqList;

	public RequestChat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestChat(int chatIdx, String chatName, int requestIdx, String helper, String writer,
			List<RequestReg> reqList) {
		super();
		this.chatIdx = chatIdx;
		this.chatName = chatName;
		this.requestIdx = requestIdx;
		this.helper = helper;
		this.writer = writer;
		this.reqList = reqList;
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

	public List<RequestReg> getRegList() {
		return reqList;
	}

	public void setRegList(List<RequestReg> reqList) {
		this.reqList = reqList;
	}
	
	
	
	
	
}
