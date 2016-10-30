package org.dudukri.domain;

import java.sql.Date;

public class QnAVO {
	
	private Integer qnaNo;		// 질문 번호
	private String memberId;	// 회원 계정
	private String qnaTitle;	// 질문 제목
	private String qnaContent;	// 질문 내용
	private char qnaStatus;		// 답변 상태
	private Date regdate;		// 작성 날짜
	private Date modidate;		// 수정 날짜
	private char deleted;		// 삭제 여부
	
	public Integer getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(Integer qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public char getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(char qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		return "QnAVO [qnaNo=" + qnaNo + ", memberId=" + memberId + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaStatus=" + qnaStatus + ", regdate=" + regdate + ", modidate=" + modidate
				+ ", deleted=" + deleted + "]";
	}
	
}
