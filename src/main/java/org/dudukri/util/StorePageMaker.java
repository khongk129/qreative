package org.dudukri.util;

public class StorePageMaker {

	private String 	customerId;		// 회원 계정
	private Integer	itemNo;			// 데이터를 itemNo
	private Integer page;			// 현재 페이지
	private Integer start;			// 시작 페이지
	private Integer end;			// 끝 페이지
	private Integer totalCount;		// 페이징을 위한 총 데이터 수
	private Boolean prev, next;		// 이전, 다음
	
	private int 	limitPageNum;	// 처음 시작 page
	private int 	perListNum;		// perListNum 한 화면에 보여줄 List의 수 ex) 10개씩, 20씩, 30개씩....
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {

		if (page < 1) { // 만약 페이지 번호가 1보다 작을 경우
			this.page = 1; // 기본 값을 1로 
			return; // 
		}

		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {

		this.totalCount = totalCount;
		calcPage();
	}
	
	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		
		this.end = end; 
	}

	private void calcPage() {

		int tempEnd = 0; //무쓸모

		this.start = 1;

		this.end = (int) Math.ceil(this.totalCount / (double)perListNum);
		
		this.prev = this.page != 1;

		this.next = this.end != this.page;
		
		//this.next = this.end * perListNum < this.totalCount;
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
	
	public int getLimitPageNum() {
		return limitPageNum;
	}

	public void setLimitPageNum(int limitPageNum) {
		this.limitPageNum = limitPageNum;
	}


	public int getPerListNum() {
		return perListNum;
	}

	public void setPerListNum(int perListNum) {
		this.limitPageNum = (page - 1) * perListNum;
		this.perListNum = perListNum;
	}

	@Override
	public String toString() {
		return "StorePageMaker [customerId=" + customerId + ", itemNo=" + itemNo + ", page=" + page + ", start=" + start
				+ ", end=" + end + ", totalCount=" + totalCount + ", prev=" + prev + ", next=" + next
				+ ", limitPageNum=" + limitPageNum + ", perListNum=" + perListNum + "]";
	}

}

