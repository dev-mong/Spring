package com.aia.rl.model;

import java.util.List;

public class RequestRegView {

	// 전체 리스트 수
	private int listTotalCnt;

	// 전체 페이지의 개수
	private int pageTotalCount;

	// 페이지 당 표현 할 정보 개수 - 상수
	private int requestCountPage;

	// 현재 페이지의 번호
	private int currentPageNum;

	// 출력 할 멤버 리스트
	private List<RequestReg> requestReg;

	// 게시물의 시작 행
	private int startRow;
	

	public RequestRegView(int listTotalCnt, int requestCountPage, int currentPageNum, List<RequestReg> requestReg,
			int startRow) {
		this.listTotalCnt = listTotalCnt;
		this.requestCountPage = requestCountPage;
		this.currentPageNum = currentPageNum;
		this.requestReg = requestReg;
		this.startRow = startRow;
		calTotalCount();
	}

	// 전체 페이지를 구하는 메소드
	private void calTotalCount() {
		if (listTotalCnt == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = listTotalCnt / requestCountPage;
			if (listTotalCnt % requestCountPage > 0) {
				pageTotalCount++;
			}

		}
	}

	public int getListTotalCnt() {
		return listTotalCnt;
	}

	public void setListTotalCnt(int listTotalCnt) {
		this.listTotalCnt = listTotalCnt;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getRequestCountPage() {
		return requestCountPage;
	}

	public void setRequestCountPage(int requestCountPage) {
		this.requestCountPage = requestCountPage;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public List<RequestReg> getRequestReg() {
		return requestReg;
	}

	public void setRequestReg(List<RequestReg> requestReg) {
		this.requestReg = requestReg;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}



}
