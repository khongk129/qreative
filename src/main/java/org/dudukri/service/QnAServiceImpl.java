package org.dudukri.service;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.QnAVO;
import org.dudukri.persistence.QnADAO;
import org.dudukri.util.QnAPageMaker;
import org.springframework.stereotype.Service;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Inject
	private QnADAO dao;

	// 질문 등록
	@Override
	public void setCreate(QnAVO vo) {
		
		dao.create(vo);
	}
	
	// 질문 리스트
	@Override
	public List<QnAVO> getRead(QnAPageMaker page) {

		return dao.read(page);
	}

	// 작성된 화면
	@Override
	public QnAVO getView(Integer qnaNo) {
		
		return dao.view(qnaNo);
	}

	// 질문 수정
	@Override
	public void setUpdate(QnAVO vo) {
		
		dao.update(vo);
	}

	// 질문 삭제
	@Override
	public void setDelete(Integer qnaNo) {
		
		dao.delete(qnaNo);
	}

	@Override
	public Integer getTotalCount(String memberId) {
		
		return dao.totalCount(memberId);
	}



}
