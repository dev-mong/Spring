package com.aia.mm.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Member {

	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private String uphoto;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Date regdate;

	public Member(int idx, String uid, String upw, String uname, String uphoto, Date regdate) {
		this.idx = idx;
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphoto = uphoto;
		this.regdate = regdate;
	}
	
	// MemberRegRequest -> Member
	public Member(String uid, String upw, String uname) {
		this(0, uid, upw, uname, null, null);
	}

	public Member() {
	}

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

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	// java.sql.Date -> java.util.Date
	public java.util.Date getToDate() {// ${member.toDate}
		return new java.util.Date(regdate.getTime());
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", uphoto=" + uphoto
				+ ", regdate=" + regdate + "]";
	}

}
