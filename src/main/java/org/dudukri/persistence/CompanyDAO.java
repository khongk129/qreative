package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.CompanyVO;
import org.dudukri.domain.MemberVO;
import org.dudukri.domain.ReplyVO;
import org.dudukri.domain.SerialVO;
import org.dudukri.util.CompanyPageMaker;

public interface CompanyDAO {

	// 카메라 페이지에서 사용할 카메라 전체 리스트
	public List<CameraVO> cameraList (CompanyPageMaker page);	

	// 문의사항 확인 페이지
	public List<CompanyVO> needHelpList (CompanyPageMaker page); 
	
	// 회원 페이지
	public List<MemberVO> memberList (CompanyPageMaker page); 
	public void quitMember(String memberId);	//탈퇴
	public void promoteMember(String memberId); //승급
	public void demoteMember(String memberId);  //강등

	// 시리얼 페이지 
	public List<SerialVO> serialList(CompanyPageMaker page);        
	public void inputSerial(String cameraId);       //시리얼 등록
	public void deleteSerial(String cameraId);  //시리얼 삭제

	// 메인 페이지 수치 정보에 사용 될 값 구하는 기능
	public Integer totalSerial();			    //전체 시리얼 
	public Integer totalCamera();			    //전체 카메라수
	public Integer totalMember();			    //전체 회원수 
	public Integer totalNeedHelp();			    //전체 문의수
	public Integer totalRecentMember();			//최근 가입멤버수
	public Integer totalQuitMember();			//탈퇴 멤버수
	public Integer totalRecentCamera();			//최근 설치카메라수
	public Integer totalDisabledCamera();		//고장난 카메라수
	public Integer totalNotyetAnsweredQna();	//미답변 QNA수

	public List<CompanyVO> mainMemberList();	 //메인 페이지 요약 리스트에 사용될 데이터 뽑는 기능
	public List<CompanyVO> mainCameraList();	 //메인 페이지 요약 리스트에 사용될 데이터 뽑는 기능
	public List<CompanyVO> mainQnaList();	     //메인 페이지 요약 리스트에 사용될 데이터 뽑는 기능
	
	public CompanyVO needHelpView(Integer qnaNo);// 문의사항 뷰
	public void qnaStatus(ReplyVO vo);		 // 답변상태업데이트	
}
