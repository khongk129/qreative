package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.TimeLapseVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TimeLapseDAOImpl implements TimeLapseDAO {
	
	@Inject
	private SqlSessionTemplate session;

	@Override
	public List<TimeLapseVO> read(String memberId) {
		
		return session.selectList("org.dudukri.persistence.TimeMapper.timeread", memberId);
	
	}

	@Override
	public void timeNameModify(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.timenamemodify", vo);
		
	}

	@Override
	public void cameraNickModify(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.cameranickmodify", vo);
		
	}
	
	@Override
	public void encoding(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.encoding", vo);
		
	}
	
	@Override
	public void qrInfoUpdate(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.qrinfoupdate", vo);
		
	}

	@Override
	public void qrPathUpdate(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.qrpathupdate", vo);
		
	}
	
	@Override
	public List<TimeLapseVO> viewHistory(String memberId) {
		return session.selectList("org.dudukri.persistence.TimeMapper.viewhistory", memberId);
	}
	
	@Override
	public void timeCount(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.timecount", vo);
		
	}
	
	@Override
	public void timeCreate(TimeLapseVO vo) {
		session.insert("org.dudukri.persistence.TimeMapper.timecreate", vo);
		
	}

	@Override
	public TimeLapseVO checkCameraId(String cameraId) {
		return session.selectOne("org.dudukri.persistence.TimeMapper.checkCameraId", cameraId);
	}
	
	@Override
	public void timeImgPathModify(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.timeImgPathModify", vo);
	}
	
	@Override
	public void timeStatus(TimeLapseVO vo) {
		session.update("org.dudukri.persistence.TimeMapper.timeStatus", vo);
		
	}

}
