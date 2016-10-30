package org.dudukri.domain;

import java.sql.Date;

public class MemberVO {
	
	private String memberName;	// 회원 이름
	private String memberId;	// 회원 아이디
	private String memberPw;	// 회원 비밀번호
	private String memberPhone;	// 회원 전화번호
	private String memberEmail;	// 회원 이메일
	private Double lat;			// 위도
	private Double lng;			// 경도
	private Date regdate;		// 작성날짜
	private Date modidate;		// 수정날짜
	private char deleted;		// 삭제여부
	
	//추가해야
	private String memberAddress;
	private char memberRole;
	private Integer cameraCount ; 
	
	
	public Integer getCameraCount() {
		return cameraCount;
	}
	public void setCameraCount(Integer cameraCount) {
		this.cameraCount = cameraCount;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
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
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public char getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(char memberRole) {
		this.memberRole = memberRole;
	}
	@Override
	public String toString() {
		return "MemberVO [memberName=" + memberName + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", lat=" + lat + ", lng=" + lng
				+ ", regdate=" + regdate + ", modidate=" + modidate + ", deleted=" + deleted + ", memberAddress="
				+ memberAddress + ", memberRole=" + memberRole + ", cameraCount=" + cameraCount + "]";
	}
	
	
 
}
