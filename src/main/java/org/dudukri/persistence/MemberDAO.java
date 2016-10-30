package org.dudukri.persistence;

import org.dudukri.domain.LoginDTO;
import org.dudukri.domain.MemberVO;

public interface MemberDAO {
	
	public MemberVO login	(LoginDTO dto);		// 로그인
	public MemberVO read	(String memberId);	// 개인 정보
	public void update		(MemberVO vo);		// 개인 정보 수정
	public void delete		(MemberVO vo);		// 삭제 여부
	public int IdCheck		(String id);              //회원가입 아이디체크
	public void InsertMember(MemberVO vo);      //회원가입

}
