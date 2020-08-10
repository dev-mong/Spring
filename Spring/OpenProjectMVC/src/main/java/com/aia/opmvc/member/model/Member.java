package com.aia.opmvc.member.model;


import org.springframework.web.multipart.MultipartFile;

public class Member {
	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private MultipartFile  photo;
	private String uploadPhoto;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getUploadPhoto() {
		return uploadPhoto;
	}
	public void setUploadPhoto(String uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", photo=" + photo
				+ ", uploadPhoto=" + uploadPhoto + "]";
	}
	

	


}