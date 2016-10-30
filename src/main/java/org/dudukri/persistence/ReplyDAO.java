package org.dudukri.persistence;

import org.dudukri.domain.ReplyVO;

public interface ReplyDAO {
	
	public ReplyVO replyRead(Integer qnaNo);
	
	public void needHelpCreate(ReplyVO vo);					 // 문의사항 댓글 추가
	public void needHelpUpdate(ReplyVO vo);					 // 문의사항 댓글 수정
}
