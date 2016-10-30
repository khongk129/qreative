package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.util.CameraPageMaker;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarmeraDAOImpl implements CameraDAO{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public CameraVO read(int cno) {
		
		return sqlSession.selectOne("org.dudukri.persistence.CameraMapper.read", cno);
	}
	
	
	@Override
	public List<CameraVO> listRead() {
		
		return sqlSession.selectList("org.dudukri.persistence.CameraMapper.listRead");
	}
	
	@Override
	public List<CameraVO> read(CameraPageMaker pagemaker) {
		
		int curPage = pagemaker.getCurPage();
		int Page = ((curPage-1)*10);
		pagemaker.setPage(Page);
		
		return sqlSession.selectList("org.dudukri.persistence.CameraMapper.readPage", pagemaker);
	}
	

	@Override
	public void nickUpdate(CameraVO vo) {
		
		sqlSession.update("org.dudukri.persistence.CameraMapper.nickUpdate", vo);
	}

	@Override
	public void timerUpdate(CameraVO vo) {
		
		sqlSession.update("org.dudukri.persistence.CameraMapper.timerUpdate", vo);
	}

	@Override
	public void registerCamera(CameraVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("org.dudukri.persistence.CameraMapper.registerCamera", vo);
	}

	@Override
	public void deletedCamera(int cno) {
		
		sqlSession.update("org.dudukri.persistence.CameraMapper.deleteCamera", cno);
	}

	@Override
	public int getCount(String memberId) {
		
		return sqlSession.selectOne("org.dudukri.persistence.CameraMapper.count", memberId);
	}

	@Override
	public void statusUpdate(CameraVO vo) {

		sqlSession.update("org.dudukri.persistence.CameraMapper.statusUpdate", vo);
	}
	
	@Override
	public int cameraNumCheck(TimeLapseVO vo) {
		return sqlSession.selectOne("org.dudukri.persistence.CameraMapper.cameraNumcheck", vo);
	}


	@Override
	public CameraVO idRead(String cameraId) {
		
		return sqlSession.selectOne("org.dudukri.persistence.CameraMapper.idRead", cameraId);
	}


	@Override
	public Boolean idCheck(String cameraId) {
		
		return sqlSession.selectOne("org.dudukri.persistence.CameraMapper.idCheck", cameraId);
	}
	
}
