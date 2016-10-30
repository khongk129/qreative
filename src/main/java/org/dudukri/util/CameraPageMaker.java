package org.dudukri.util;

public class CameraPageMaker {

	String memberId;
	int page;
	int startPage;
	int endPage;
	int curPage;
	int count;
	boolean prev;
	boolean next;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setCurPage(int curPage) {
		
		if( curPage < 1){
			curPage = 1;
		}
		
		this.curPage = curPage;
	}

	public void calcPage(){
		
		// 현재 페이지를 기준으로 End페이지 계산
		int tempEnd = (int)(Math.ceil(this.curPage/10.0) * 10);
		
		// 시작 페이지 계산
		this.startPage = tempEnd - 9;
		
		// End페이지 기준으로 마지막 페이지 계산.
		if( (tempEnd*10) > this.count ){
			
			this.endPage = (int)Math.ceil(this.count/10.0);
			this.next = false;
			
		}else{
			
			this.endPage = tempEnd;
		}
		
		
		this.prev = this.startPage != 1;
		this.next = this.endPage * 10 < this.count;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getCurPage() {
		return curPage;
	}
	
	public boolean getPrev() {
		return prev;
	}
	public boolean getNext() {
		return next;
	}
	@Override
	public String toString() {
		return "CameraPageMaker [memberId=" + memberId + ", page=" + page + ", startPage=" + startPage + ", endPage="
				+ endPage + ", curPage=" + curPage + ", count=" + count + ", prev=" + prev + ", next=" + next + "]";
	}
	
}
