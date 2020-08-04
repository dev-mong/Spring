package com.aia.opmvc.member.model;

public class LoginInfo {

	private String uid;
	private String upw;
	private String uphoto;
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
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", upw=" + upw + ", uphoto=" + uphoto + "]";
	}
	
	
	
	
}
