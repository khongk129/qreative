package org.dudukri.service;

import org.dudukri.domain.LoginDTO;
import org.dudukri.domain.MemberVO;

public interface MemberService {

	public MemberVO login	(LoginDTO dto);		// 로그인
	public MemberVO getRead	(String memberId);	// 개인 정보
	public void setUpdate	(MemberVO vo);		// 개인 정보 수정
	public void setDelete	(MemberVO vo);		// 회원탈퇴
	public int IdCheck		(String id);		// 회원가입시 아이디체크
	public void InsertMember(MemberVO vo);		// 회원가입
}
