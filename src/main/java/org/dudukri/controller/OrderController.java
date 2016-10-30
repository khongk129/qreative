package org.dudukri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.BookmarkVO;
import org.dudukri.domain.MyItemsBoardVO;
import org.dudukri.domain.OrderVO;
import org.dudukri.service.MyItemsBoardService;
import org.dudukri.service.OrderService;
import org.dudukri.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

	@Inject
	OrderService service;
	
	@Inject
	StoreService storeService;
	
	@Inject
	MyItemsBoardService itemService;
	
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	// List를 사용하려면 ResponseBody사용
	@RequestMapping(value = "/list/{memberId}/{page}", method = RequestMethod.GET)
	public Map<String, Object> listRead(@PathVariable("memberId") String memberId, @PathVariable("page") int page) {

		logger.info("memberId =" + memberId);
		logger.info("page =" + page);
		
		MyItemsBoardVO myItemsBoardVO = new MyItemsBoardVO();
		Map<String, Object> map = new HashMap<>();
		
		List<OrderVO> list = service.listRead(memberId);
		
		for(int i=0; i< list.size(); i++){
			myItemsBoardVO.setItemNo(list.get(i).getItemNo());
			list.get(i).setItem(itemService.viewItems(myItemsBoardVO));
		}
		
		
		logger.info(list.toString());
		map.put("list", list);
		
		return map;
	}
	
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public void updateStatus(@RequestBody OrderVO vo) {

		logger.info("START updateStatus ="+vo.toString());
		
		service.updateStatus(vo);
	}
	
	@RequestMapping(value = "/ordercheck/{customerId}", method = RequestMethod.GET)
	public OrderVO orderCheck(@PathVariable("customerId") String customerId){

		return service.orderCheck(customerId);
	}
	
	@RequestMapping(value = "/ordercreate", method = RequestMethod.POST)
	public void orderCreate(@RequestBody OrderVO vo){

		logger.info("start onderCreate"+vo.toString());
		service.orderCreate(vo);
		
	}
	
	
	@RequestMapping(value = "/pointcreate", method = RequestMethod.POST)
	public void pointCreate(@RequestBody BookmarkVO vo){
		
		logger.info("start pointCreate"+vo.toString());
		storeService.setPointCreate(vo);
	}
	
}
