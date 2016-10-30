package org.dudukri.domain;

import java.sql.Date;

public class ReplyVO {
	
	private Integer replyNo;		// 댓글 번호
	private Integer qnaNo;			// 질문 번호
	private String 	replyContent;	// 질문 답변 댓글
	private Date 	regdate;		// 작성날짜
	private Date 	modidate;		// 수정날짜
	private char 	deleted;		// 삭제여부
	
	public Integer getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(Integer replyNo) {
		this.replyNo = replyNo;
	}
	public Integer getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(Integer qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
		return "ReplyVO [replyNo=" + replyNo + ", qnaNo=" + qnaNo + ", replyContent=" + replyContent + ", regdate="
				+ regdate + ", modidate=" + modidate + ", deleted=" + deleted + "]";
	}
	
	
}
