package org.dudukri.service;

import javax.inject.Inject;

import org.dudukri.domain.LoginDTO;
import org.dudukri.domain.MemberVO;
import org.dudukri.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	// 로그인
	@Override
	public MemberVO login(LoginDTO dto) {

		return dao.login(dto);
	}

	// 개인 정보
	@Override
	public MemberVO getRead(String memberId) {

		return dao.read(memberId);
	}

	// 개인 정보 수정
	@Override
	public void setUpdate(MemberVO vo) {

		dao.update(vo);
	}

	// 회원탈퇴
	@Override
	public void setDelete(MemberVO vo) {

		dao.delete(vo);
	}

	@Override
	public int IdCheck(String id) {

		return dao.IdCheck(id);
	}

	@Override
	public void InsertMember(MemberVO vo) {

		dao.InsertMember(vo);
	}
}
