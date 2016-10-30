package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.CompanyVO;
import org.dudukri.domain.MemberVO;
import org.dudukri.domain.ReplyVO;
import org.dudukri.domain.SerialVO;
import org.dudukri.util.CompanyPageMaker;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO{
	
	private final String PATH = "org.dudukri.persistence.CompanyMapper";
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberVO> memberList(CompanyPageMaker page) {
		
		return sqlSession.selectList(PATH + ".listall", page);
	}
	
	@Override
	public List<CameraVO> cameraList(CompanyPageMaker page) {
		
		return sqlSession.selectList(PATH + ".listcamera", page);
	}
	
	@Override
	public List<SerialVO> serialList(CompanyPageMaker page) {
		
		return sqlSession.selectList(PATH + ".listserial", page);
	}
	
	@Override
	public Integer totalMember() {

		return sqlSession.selectOne(PATH + ".membercount");
	}
	
	@Override
	public Integer totalCamera() {
		return sqlSession.selectOne(PATH + ".cameracount");
	}

	@Override
	public Integer totalSerial() {
		return sqlSession.selectOne(PATH + ".serialcount");
	}


	@Override
	public List<CompanyVO> mainMemberList() {
		
		return sqlSession.selectList(PATH + ".mainmemberlist");
	}
	
	@Override
	public List<CompanyVO> mainCameraList() {
		return sqlSession.selectList(PATH + ".maincameralist");
	}

	@Override
	public List<CompanyVO> mainQnaList() {
		return sqlSession.selectList(PATH + ".mainqnalist");
	}

	@Override
	public Integer totalRecentMember() {
		return sqlSession.selectOne(PATH + ".totalRecentMember");
	}
	
	@Override
	public Integer totalQuitMember() {
		return sqlSession.selectOne(PATH + ".totalQuitMember");
	}

	@Override
	public Integer totalRecentCamera() {
		return sqlSession.selectOne(PATH + ".totalRecentCamera");
	}

	@Override
	public Integer totalDisabledCamera() {
		return sqlSession.selectOne(PATH + ".totalDisabledCamera");
	}

	@Override
	public Integer totalNotyetAnsweredQna() {
		return sqlSession.selectOne(PATH + ".totalNotyetAnsweredQna");
	}

	@Override
	public void quitMember(String memberId) {
		sqlSession.update(PATH + ".quitmember", memberId);
	}

	@Override
	public void promoteMember(String memberId) {
		sqlSession.update(PATH + ".promotemember", memberId);
	}

	@Override
	public void demoteMember(String memberId) {
		sqlSession.update(PATH + ".demotemember", memberId);
	}

	
	@Override
	public void inputSerial(String cameraId) {
		sqlSession.insert(PATH + ".inputserial", cameraId);
		
	}

	@Override
	public void deleteSerial(String cameraId) {
		sqlSession.update(PATH + ".deleteserial", cameraId);
		
	}

	@Override
	public List<CompanyVO> needHelpList(CompanyPageMaker page) {
		return sqlSession.selectList(PATH + ".listneedhelp", page);
	}

	@Override
	public Integer totalNeedHelp() {
		return sqlSession.selectOne(PATH + ".needhelpcount");
	}

	@Override
	public CompanyVO needHelpView(Integer qnaNo) {
		return sqlSession.selectOne(PATH + ".needhelpview", qnaNo);
	}

	@Override
	public void qnaStatus(ReplyVO vo) {
		sqlSession.update(PATH + ".qnastatus", vo);
	}

	
}
