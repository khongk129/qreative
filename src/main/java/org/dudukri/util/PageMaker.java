package org.dudukri.util;


public class PageMaker {
	
	private String memberId;

	private int page;
	private int totalCount;
	private int Start, end;
	
	//perPageNum 하단에 보여줄 페이지 수 ex) <prev> 1 2 3 4 5 <next>
	//perListNum 한 화면에 보여줄 List의 수 ex) 10개씩, 20씩, 30개씩....
	private int perPageNum;
	private int perListNum;
	
	private int limitPageNum;
	
	private boolean prev, next;
	
	private int cameraNo;
	
	public void calcPage(){
		
		int tempEnd = (int) (Math.ceil(page/(double)perPageNum)*perPageNum);
		Start = tempEnd - (perPageNum - 1);
		
		int onePageCnt = (int) Math.ceil(totalCount / (double)perPageNum);
		
		if(tempEnd < onePageCnt){
			
			end = tempEnd;
			
			next = true;
		}
		else{
			 end = onePageCnt;
		}
		
		
		if(Start != 1){
			prev = true;
		}
		
	}
	
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getLimitPageNum() {
		return limitPageNum;
	}


	public void setLimitPageNum(int limitPageNum) {
		
		this.limitPageNum = limitPageNum;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		
		if(page <1){
			this.page = 1;
			return;
		}
		
		this.page = page;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		
		if(totalCount<1){
			return;
		}
		
		this.totalCount = totalCount;
	}


	public int getStart() {
		return Start;
	}


	public void setStart(int start) {
		this.Start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public int getPerPageNum() {
		return perPageNum;
	}


	public void setPerPageNum(int perPageNum) {
		if(perPageNum <2){
			return;
		}
		this.perPageNum = perPageNum;
	}


	public int getPerListNum() {
		return perListNum;
	}


	public void setPerListNum(int perListNum) {
		this.limitPageNum=(page-1)*perListNum;
		this.perListNum = perListNum;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getCameraNo() {
		return cameraNo;
	}


	public void setCameraNo(int cameraNo) {
		this.cameraNo = cameraNo;
	}

	@Override
	public String toString() {
		return "PageMaker [memberId=" + memberId + ", page=" + page + ", totalCount=" + totalCount + ", Start=" + Start
				+ ", end=" + end + ", perPageNum=" + perPageNum + ", perListNum=" + perListNum + ", limitPageNum="
				+ limitPageNum + ", prev=" + prev + ", next=" + next + ", cameraNo=" + cameraNo + "]";
	}
	
}
