package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.QnAVO;
import org.dudukri.util.QnAPageMaker;

public interface QnADAO {

	public void create			(QnAVO vo);			// 질문 등록
	public List<QnAVO> read		(QnAPageMaker page);	// 질문 리스트
	public QnAVO view 			(Integer qnaNo);	// 작성된 화면
	public void update			(QnAVO vo);			// 질문 수정
	public void delete			(Integer qnaNo);	// 삭제 여부
	public Integer totalCount	(String memberId);	// 페이징에 필요한 데이터 총 갯수
}
