package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.OrderVO;

public interface OrderDAO {

	public List<OrderVO> listRead(String memberId);

	public void updateStatus(OrderVO vo);

	public OrderVO orderCheck(String customerId);

	public void orderCreate(OrderVO vo);

}
