package org.dudukri.domain;

import java.sql.Date;

public class CompanyVO {

	// 메인 페이지에 뿌릴때 쓸 VO - 멤버
	private String memberName;	// 회원 이름
	private String memberId;	// 회원 아이디
	private Date regdate;	    // 가입날짜
	private Integer memberRole; // 멤버 레벨
	
	// 메인 페이지에 뿌릴때 쓸 VO - QNA
	private Integer qnaNo;		// 질문 번호
	private String qnaTitle;	// 질문 제목
	private char qnaStatus;     // 질문 상태
	private String qnaContent;  // 질문 내용
	
	
	// 메인 페이지에 뿌릴때 쓸 VO - 카메라
	private int cameraNo;			// 카메라 번호
	private String cameraId;		// 카메라 시리얼
	private Date cameraInsdate;		// 카메라 설치일
	private String cameraStatus;	// 카메라 상태
	
	// 메인 페이지 수치 정보를 담을 VO 
	private Integer totalMember;			// 총 멤버
	private Integer totalQuitMember;		// 탈퇴 멤버
	private Integer totalRecentMember;		// 최근 가입 멤버
	private Integer totalRecentCamera;		// 최근 설치 카메라
	private Integer totalDisabledCamera;	// 고장 카메라
	private Integer totalNotyetAnsweredQna;	// 미답변 게시물
	
	
	public Integer getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(Integer memberRole) {
		this.memberRole = memberRole;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Integer getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(Integer qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public char getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(char qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	public int getCameraNo() {
		return cameraNo;
	}
	public void setCameraNo(int cameraNo) {
		this.cameraNo = cameraNo;
	}
	public String getCameraId() {
		return cameraId;
	}
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	public Date getCameraInsdate() {
		return cameraInsdate;
	}
	public void setCameraInsdate(Date cameraInsdate) {
		this.cameraInsdate = cameraInsdate;
	}
	public String getCameraStatus() {
		return cameraStatus;
	}
	public void setCameraStatus(String cameraStatus) {
		this.cameraStatus = cameraStatus;
	}
	public Integer getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(Integer totalMember) {
		this.totalMember = totalMember;
	}
	public Integer getTotalQuitMember() {
		return totalQuitMember;
	}
	public void setTotalQuitMember(Integer totalQuitMember) {
		this.totalQuitMember = totalQuitMember;
	}
	public Integer getTotalRecentMember() {
		return totalRecentMember;
	}
	public void setTotalRecentMember(Integer totalRecentMember) {
		this.totalRecentMember = totalRecentMember;
	}
	public Integer getTotalRecentCamera() {
		return totalRecentCamera;
	}
	public void setTotalRecentCamera(Integer totalRecentCamera) {
		this.totalRecentCamera = totalRecentCamera;
	}
	public Integer getTotalDisabledCamera() {
		return totalDisabledCamera;
	}
	public void setTotalDisabledCamera(Integer totalDisabledCamera) {
		this.totalDisabledCamera = totalDisabledCamera;
	}
	public Integer getTotalNotyetAnsweredQna() {
		return totalNotyetAnsweredQna;
	}
	public void setTotalNotyetAnsweredQna(Integer totalNotyetAnsweredQna) {
		this.totalNotyetAnsweredQna = totalNotyetAnsweredQna;
	}
	
	@Override
	public String toString() {
		return "CompanyVO [memberName=" + memberName + ", memberId=" + memberId + ", regdate=" + regdate
				+ ", memberRole=" + memberRole + ", qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaStatus="
				+ qnaStatus + ", qnaContent=" + qnaContent + ", cameraNo=" + cameraNo + ", cameraId=" + cameraId
				+ ", cameraInsdate=" + cameraInsdate + ", cameraStatus=" + cameraStatus + ", totalMember=" + totalMember
				+ ", totalQuitMember=" + totalQuitMember + ", totalRecentMember=" + totalRecentMember
				+ ", totalRecentCamera=" + totalRecentCamera + ", totalDisabledCamera=" + totalDisabledCamera
				+ ", totalNotyetAnsweredQna=" + totalNotyetAnsweredQna + "]";
	}

}
