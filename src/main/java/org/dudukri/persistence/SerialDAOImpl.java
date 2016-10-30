package org.dudukri.persistence;

import javax.inject.Inject;

import org.dudukri.domain.SerialVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SerialDAOImpl implements SerialDAO {

	@Inject
	SqlSessionTemplate sqlSession;
	
	@Override
	public Boolean serialidRead(String cameraId) {
		
		System.out.println("serialidRead(String cameraId) = "+cameraId);
		
		return sqlSession.selectOne("org.dudukri.persistence.SerialMapper.serialidRead", cameraId);
	}

	@Override
	public SerialVO read() {
		System.out.println("START Serial read()");
		return sqlSession.selectOne("org.dudukri.persistence.SerialMapper.read");
	}
}
