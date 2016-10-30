package org.dudukri.service;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.CompanyVO;
import org.dudukri.domain.MemberVO;
import org.dudukri.domain.ReplyVO;
import org.dudukri.domain.SerialVO;
import org.dudukri.persistence.CompanyDAO;
import org.dudukri.util.CompanyPageMaker;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Inject
	private CompanyDAO dao;

	@Override
	public List<MemberVO> memberList(CompanyPageMaker page) {
		return dao.memberList(page);
	}

	@Override
	public List<CameraVO> cameraList(CompanyPageMaker page) {
		return dao.cameraList(page);
	}

	@Override
	public List<SerialVO> serialList(CompanyPageMaker page) {
		return dao.serialList(page);
	}

	@Override
	public Integer totalMember() {
		return dao.totalMember();
	}

	@Override
	public Integer totalCamera() {
		return dao.totalCamera();
	}

	@Override
	public Integer totalSerial() {
		return dao.totalSerial();
	}

	@Override
	public List<CompanyVO> mainMemberList() {
		return dao.mainMemberList();
	}

	@Override
	public List<CompanyVO> mainCameraList() {
		return dao.mainCameraList();
	}

	@Override
	public List<CompanyVO> mainQnaList() {
		return dao.mainQnaList();
	}

	@Override
	public Integer totalRecentMember() {
		return dao.totalRecentMember();
	}

	@Override
	public Integer totalQuitMember() {
		return dao.totalQuitMember();
	}

	@Override
	public Integer totalRecentCamera() {
		return dao.totalRecentCamera();
	}

	@Override
	public Integer totalDisabledCamera() {
		return dao.totalDisabledCamera();
	}

	@Override
	public Integer totalNotyetAnsweredQna() {
		return dao.totalNotyetAnsweredQna();
	}

	@Override
	public void quitMember(String memberId) {
		dao.quitMember(memberId);
	}

	@Override
	public void promoteMember(String memberId) {
		dao.promoteMember(memberId);
	}

	@Override
	public void demoteMember(String memberId) {
		dao.demoteMember(memberId);
	}


	@Override
	public void inputSerial(String cameraId) {
		dao.inputSerial(cameraId);
	}

	@Override
	public void deleteSerial(String cameraId) {
		dao.deleteSerial(cameraId);		
	}

	@Override
	public List<CompanyVO> needHelpList(CompanyPageMaker page) {
		return dao.needHelpList(page);
	}

	@Override
	public Integer totalNeedHelp() {
		return dao.totalNeedHelp();
	}

	@Override
	public CompanyVO needHelpView(Integer qnaNo) {
		return dao.needHelpView(qnaNo);
	}

	@Override
	public void qnaStatus(ReplyVO vo) {
		dao.qnaStatus(vo);
		
	}

}
