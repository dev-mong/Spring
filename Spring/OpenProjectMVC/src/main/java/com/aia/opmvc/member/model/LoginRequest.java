package com.aia.opmvc.member.model;

public class LoginRequest {

	private String uid;
	private String upw;
	private String check;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "LoginRequest [uid=" + uid + ", upw=" + upw + ", check=" + check + "]";
	}
	
	
	
}
