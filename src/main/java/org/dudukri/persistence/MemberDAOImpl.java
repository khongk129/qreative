package org.dudukri.persistence;

import javax.inject.Inject;

import org.dudukri.domain.LoginDTO;
import org.dudukri.domain.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	private final String PATH = "org.dudukri.persistence.MemberMapper";

	@Inject
	private SqlSessionTemplate sqlSession;

	// 로그인
	@Override
	public MemberVO login(LoginDTO dto) {

		return sqlSession.selectOne(PATH + ".login", dto);
	}

	// 개인 정보
	@Override
	public MemberVO read(String memberId) {

		System.out.println(memberId);
		return sqlSession.selectOne(PATH + ".read", memberId);
	}

	// 개인 정보 수정
	@Override
	public void update(MemberVO vo) {

		sqlSession.update(PATH + ".update", vo);
	}

	// 삭제 여부
	@Override
	public void delete(MemberVO vo) {

		sqlSession.delete(PATH + ".delete", vo);
	}

	// 회원가입 아이디 체크
	@Override
	public int IdCheck(String id) {
		return sqlSession.selectOne(PATH + ".idcheck", id);
	}

	// 회원가입
	@Override
	public void InsertMember(MemberVO vo) {
		sqlSession.insert(PATH + ".insertmember", vo);
	}

}
