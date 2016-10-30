package org.dudukri.domain;

public class LoginDTO {
	
	private String 	memberId;	// 로그인시 필요한 회원 계정
	private String 	memberPw;	// 로그인시 필요한 회원 비밀번호
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	@Override
	public String toString() {
		return "LoginDTO [memberId=" + memberId + ", memberPw=" + memberPw + "]";
	}
	
}
