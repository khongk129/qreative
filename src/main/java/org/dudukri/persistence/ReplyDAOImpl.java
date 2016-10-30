package org.dudukri.persistence;

import javax.inject.Inject;

import org.dudukri.domain.ReplyVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	String PATH = "org.dudukri.persistence.ReplyMapper";
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ReplyVO replyRead(Integer qnaNo) {
		
		return sqlSession.selectOne(PATH + ".replyRead", qnaNo);
	}
	
	@Override
	public void needHelpCreate(ReplyVO vo) {
		sqlSession.insert("org.dudukri.persistence.ReplyMapper.replyCreate", vo);	
	}

	@Override
	public void needHelpUpdate(ReplyVO vo) {
		sqlSession.update("org.dudukri.persistence.ReplyMapper.replyUpdate", vo);
	}

}
