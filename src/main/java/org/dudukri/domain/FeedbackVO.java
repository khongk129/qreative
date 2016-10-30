package org.dudukri.domain;

import java.sql.Date;

public class FeedbackVO {

	private Integer itemNo; 	 //아이템 번호
	private String customerId;	 //작성자
	private String feedback; 	//댓글내용
	private Integer rating; 	//평점
	private Date regDate;
	private boolean deleted;
	public Integer getItemNo() {
		return itemNo;
	}
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "FeedbackVO [itemNo=" + itemNo + ", customerId=" + customerId + ", feedback=" + feedback + ", rating="
				+ rating + ", regDate=" + regDate + ", deleted=" + deleted + "]";
	}
	
	
}
