package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.OrderVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<OrderVO> listRead(String memberId) {
		
		return sqlSession.selectList("org.dudukri.persistence.OrderMapper.listRead", memberId);
	}

	@Override
	public void updateStatus(OrderVO vo) {
		
		sqlSession.update("org.dudukri.persistence.OrderMapper.statusUpdate", vo);
	}
	
	@Override
	public OrderVO orderCheck(String customerId) {
		
		return sqlSession.selectOne("org.dudukri.persistence.OrderMapper.orderCheck", customerId);
	}

	@Override
	public void orderCreate(OrderVO vo) {
		System.out.println(vo.toString());
		sqlSession.insert("org.dudukri.persistence.OrderMapper.orderCreate", vo);
		
	}
}
