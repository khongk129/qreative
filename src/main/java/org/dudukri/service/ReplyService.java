package org.dudukri.service;

import org.dudukri.domain.ReplyVO;

public interface ReplyService {

	public ReplyVO getReplyRead(Integer qnaNo);
	
	public void needHelpCreate(ReplyVO vo);					 // 문의사항 댓글 추가
	public void needHelpUpdate(ReplyVO vo);					 // 문의사항 댓글 수정
}
