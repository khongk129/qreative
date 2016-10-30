package org.dudukri.service;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.OrderVO;
import org.dudukri.persistence.OrderDAO;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderDAO dao;
	
	@Override
	public List<OrderVO> listRead(String memberId) {
		
		return dao.listRead(memberId);
	}

	@Override
	public void updateStatus(OrderVO vo) {
		
		dao.updateStatus(vo);
	}
	
	@Override
	public OrderVO orderCheck(String customerId) {
		
		if(dao.orderCheck(customerId) == null){
			OrderVO vo = new OrderVO();
			vo.setIsUser(1);
			return vo;
		}
		
		return dao.orderCheck(customerId);
	}

	@Override
	public void orderCreate(OrderVO vo) {
		dao.orderCreate(vo);
	}

}
