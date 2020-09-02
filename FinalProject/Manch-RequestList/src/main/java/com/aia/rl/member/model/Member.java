package com.aia.rl.member.model;

public class Member {
	private String mImg;
	private int avg;

	public Member() {
	}

	public Member(String mImg, int avg) {
		this.mImg = mImg;
		this.avg = avg;
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
		return "Member [mImg=" + mImg + ", avg=" + avg + "]";
	}

}
