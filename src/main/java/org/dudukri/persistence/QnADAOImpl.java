package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.QnAVO;
import org.dudukri.util.QnAPageMaker;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QnADAOImpl implements QnADAO {

	String PATH = "org.dudukri.persistence.QnAMapper";

	@Inject
	private SqlSessionTemplate sqlSession;

	// 질문 리스트
	@Override
	public List<QnAVO> read(QnAPageMaker page) {

		return sqlSession.selectList(PATH + ".read", page);
	}

	// 질문 등록
	@Override
	public void create(QnAVO vo) {
		
		sqlSession.insert(PATH + ".create", vo);
	}

	// 작성된 화면
	@Override
	public QnAVO view(Integer qnaNo) {
		
		return sqlSession.selectOne(PATH + ".view", qnaNo);
	}

	// 질문 수정
	@Override
	public void update(QnAVO vo) {
		
		sqlSession.update(PATH + ".update", vo);
	}

	// 삭제여부
	@Override
	public void delete(Integer qnaNo) {
		
		sqlSession.delete(PATH + ".delete", qnaNo);
	}

	@Override
	public Integer totalCount(String memberId) {
		
		return sqlSession.selectOne(PATH + ".count", memberId);
	}

}
