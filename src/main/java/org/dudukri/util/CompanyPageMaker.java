package org.dudukri.util;

public class CompanyPageMaker {

	private Integer curPage;			
	private Integer startPage;			
	private Integer endPage;		
	private Integer totalMember;
	private Boolean prev, next;		
	private Integer perListNum;
	private Integer startNum;
	

	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		if (curPage < 1) { 
			this.curPage = 1; 
			return;
		}
		this.curPage = curPage;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public Integer getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(Integer totalMember) {
		if (totalMember < 1) {
			return;
		}
		this.totalMember = totalMember;
		calcPage();
	}
	private void calcPage() {
		perListNum = 10;
		int tempEnd = (int) (Math.ceil(curPage / 10.0) * 10);
		this.startPage = tempEnd - 9;
		if (tempEnd * perListNum > this.totalMember) {
			this.endPage = (int) Math.ceil(this.totalMember / (double)perListNum);
		} else {
			this.endPage = tempEnd;
		}
		this.prev = this.startPage != 1;
		this.next = this.endPage * perListNum < this.totalMember;
	}
	public Boolean getPrev() {
		return prev;
	}
	public void setPrev(Boolean prev) {
		this.prev = prev;
	}
	public Boolean getNext() {
		return next;
	}
	public void setNext(Boolean next) {
		this.next = next;
	}
	public Integer getStartNum() {
		startNum = (curPage * 10)-9;
		return startNum-1;
	
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

}
