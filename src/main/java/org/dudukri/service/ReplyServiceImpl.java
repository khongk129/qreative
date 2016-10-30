package org.dudukri.service;

import javax.inject.Inject;

import org.dudukri.domain.ReplyVO;
import org.dudukri.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO dao;
	
	@Override
	public ReplyVO getReplyRead(Integer qnaNo) {

		return dao.replyRead(qnaNo);
	}

	@Override
	public void needHelpCreate(ReplyVO vo) {
		dao.needHelpCreate(vo);
	}

	@Override
	public void needHelpUpdate(ReplyVO vo) {
		dao.needHelpUpdate(vo);
	}
}
