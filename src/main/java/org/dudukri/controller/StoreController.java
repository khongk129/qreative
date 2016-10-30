package org.dudukri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.BookmarkVO;
import org.dudukri.domain.FeedbackVO;
import org.dudukri.domain.OrderVO;
import org.dudukri.domain.StoreVO;
import org.dudukri.service.StoreService;
import org.dudukri.util.PathToPathList;
import org.dudukri.util.StorePageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/store/")
public class StoreController {

	@Inject
	private StoreService service;

	private static Logger logger = LoggerFactory.getLogger(StoreController.class);

	// 메인 페이지 뷰
	@RequestMapping(value = "/bookmark/{customerId}/{page}", method = RequestMethod.GET)
	public Map<String, Object> bookmarkRead(@PathVariable("customerId") String customerId, @PathVariable("page") Integer page) {

		StorePageMaker pageMaker = new StorePageMaker();
		Map<String, Object> map = new HashMap<>();

		pageMaker.setCustomerId(customerId);;
		pageMaker.setPage(page);
		pageMaker.setPerListNum(6);
		pageMaker.setTotalCount(service.getBookmarkTotalCount(customerId));

		BookmarkVO pointRead 			= service.getPointRead(customerId);
		BookmarkVO deliveryCount 		= service.getDeliveryCount(customerId);
		List<BookmarkVO> bookmarkList 	= service.getBookmarkList(pageMaker);

		map.put("pointRead", pointRead); 		 // 포인트 관리 바
		map.put("deliveryCount", deliveryCount); // 주문정보
		map.put("bookmarkList", bookmarkList); 	 // 즐겨찾기 리스트
		map.put("pageMaker", pageMaker); 		 // 페이징

		return map;
	}

	// 구메목록 페이지 뷰
	@RequestMapping(value = "/shoppinglist/{customerId}/{page}", method = RequestMethod.GET)
	public Map<String, Object> shoppingList(@PathVariable("customerId") String customerId, @PathVariable("page") Integer page) {

		StorePageMaker pageMaker = new StorePageMaker();
		Map<String, Object> map = new HashMap<>();

		pageMaker.setCustomerId(customerId);
		pageMaker.setPage(page);
		pageMaker.setPerListNum(9);
		pageMaker.setTotalCount(service.getShoppingListTotalCount(customerId));

		List<OrderVO> orderList = service.getShoppingList(pageMaker);

		map.put("shoppingList", orderList); // 주문 완료 목록
		map.put("pageMaker", pageMaker); 	// 페이징

		return map;
	}

	// 즐겨찾기 삭제
	@RequestMapping(value = "/bookmark/deleted", method = RequestMethod.POST)
	public void bookmarkDeleted(@RequestBody Integer bookNo) {

		service.setBookmarkDeleted(bookNo);
	}

	// 댓글 등록
	@RequestMapping(value = "/shopping/feedback", method = RequestMethod.POST)
	public void shoppingFeedbackCreate(@RequestBody FeedbackVO vo) {

		service.setShoppingFeedbackCreate(vo);
	}

	// 상품 상세 페이지 전체 출력
	@RequestMapping(value = "/item/{itemNum}", method = RequestMethod.GET)
	public Map<String, Object> itemView(@PathVariable("itemNum") Integer itemNum) {

		logger.info("itemView Start: "+itemNum);
		 
		Map<String, Object> map = new HashMap<String, Object>();

		List<StoreVO> info = service.itemInfo(itemNum);

		for (StoreVO storeVO : info) {
			logger.info("storeVO :"+storeVO.toString());
		}
		
		String imgPath = info.get(0).getItemImgPath();

		PathToPathList ptpl = new PathToPathList();

		List<String> pathList = ptpl.pathList(imgPath);

		logger.info("super-info : " + info.toString());

		map.put("info", info);
		map.put("pathList", pathList);

		return map;

	}

	// 상품 상세 페이지 상품평 부분 출력
	@ResponseBody
	@RequestMapping(value = "/feed/{itemNum}/{page}", method = RequestMethod.GET)
	public Map<String, Object> feedView(@PathVariable("itemNum") Integer itemNum, @PathVariable("page") Integer page) {

		Map<String, Object> map = new HashMap<String, Object>();

		logger.info("super-page =" + page);
		logger.info("super-itemNum =" + itemNum);

		StorePageMaker pagemaker = new StorePageMaker();

		pagemaker.setPage(page);
		pagemaker.setItemNo(itemNum);
		pagemaker.setPerListNum(3);
		pagemaker.setTotalCount(service.feedCount(itemNum));

		List<FeedbackVO> feed = service.feedbackList(pagemaker);

		logger.info("super-feedback : " + feed.toString());

		map.put("feed", feed);
		map.put("page", pagemaker);

		return map;
	}

	// 즐겨찾기 등록 여부 확인
	@ResponseBody
	@RequestMapping(value = "/check/{itemNum}/{customerId}", method = RequestMethod.GET)
	public Map<String, Object> bookCheck(@PathVariable("itemNum") Integer itemNum, @PathVariable("customerId") String customerId) {

		Map<String, Object> map = new HashMap<String, Object>();

		FeedbackVO vo = new FeedbackVO();

		vo.setItemNo(itemNum);
		vo.setCustomerId(customerId);

		List<FeedbackVO> check = service.bookCheck(vo);

		logger.info("super-vo =" + check.toString());

		map.put("check", check);

		return map;
	}

	// 즐겨찾기 등록
	@ResponseBody
	@RequestMapping(value = "/addbook/{itemNum}/{customerId}", method = RequestMethod.POST)
	public String bookAdd(@PathVariable("itemNum") Integer itemNum, @PathVariable("customerId") String customerId) {

		FeedbackVO vo = new FeedbackVO();

		vo.setItemNo(itemNum);
		vo.setCustomerId(customerId);

		service.bookAdd(vo);

		String result = "added";

		return result;
	}

	// 즐겨찾기 삭제
	@ResponseBody
	@RequestMapping(value = "/delbook/{itemNum}/{customerId}", method = RequestMethod.POST)
	public String bookDel(@PathVariable("itemNum") Integer itemNum, @PathVariable("customerId") String customerId) {

		FeedbackVO vo = new FeedbackVO();

		vo.setItemNo(itemNum);
		vo.setCustomerId(customerId);

		service.bookDel(vo);

		String result = "deleted";

		return result;
	}

}
