package org.dudukri.service;

import java.util.List;

import org.dudukri.domain.QnAVO;
import org.dudukri.util.PageMaker;
import org.dudukri.util.QnAPageMaker;

public interface QnAService {

	public void setCreate		(QnAVO vo);			// 질문 등록
	public List<QnAVO> getRead	(QnAPageMaker pageMaker);	// 질문 리스트
	public QnAVO getView		(Integer qnaNo);	// 작성된 화면
	public void setUpdate 		(QnAVO vo);			// 질문 수정
	public void setDelete		(Integer qnaNo);	// 질문 삭제
	public Integer getTotalCount(String memberId);	// 페이징에 필요한 총 데이터 캣수
}
