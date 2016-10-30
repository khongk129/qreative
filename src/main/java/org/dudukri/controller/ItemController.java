package org.dudukri.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.CameraAndTimelapseInfoVO;
import org.dudukri.domain.MyItemsBoardVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.service.MyItemsBoardService;
import org.dudukri.service.TimeLapseService;
import org.dudukri.util.PageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/item/")
public class ItemController {

	private static Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Inject
	private MyItemsBoardService myItems;
	
	@Inject 
	private TimeLapseService service;
	

	// 아이템 리스트
	@RequestMapping(value = "/items/{memberId}/{page}", method = RequestMethod.GET)
	public Map<String, Object> listItems(PageMaker pageMaker) {

		logger.info("listItems Start: " + pageMaker.getPage());
		logger.info("listItems Start: " + pageMaker.getMemberId());

		// 리스트 갯수 선택
		pageMaker.setPerListNum(10);
		// 페이징 숫자 선택
		pageMaker.setPerPageNum(10);

		return myItems.listItems(pageMaker);
	}

	// 아이템 상세
	@RequestMapping(value = "/viewitems/{itemNo}", method = RequestMethod.GET)
	public MyItemsBoardVO viewItems(MyItemsBoardVO myItemsBoardVO) {
		logger.info("viewitems" + myItemsBoardVO.getItemNo());
		return myItems.viewItems(myItemsBoardVO);
	}

	
	// 상품등록버튼 눌렀을때 발생
	@RequestMapping(value = "/insertItems", method = RequestMethod.POST)
	public void insertItems(MyItemsBoardVO myItemsBoardVO) {

		logger.info("insertItems Start: "+myItemsBoardVO.toString());

		myItems.insertItems(myItemsBoardVO);

	}

	// 상품 삭제
	@RequestMapping(value = "/deleteItems", method = RequestMethod.POST)
	public void deleteItems(@RequestBody List<String> itemNums) {

		logger.info("deleteItems Start: " + itemNums);
		myItems.deleteItems(itemNums);

	}

	// 상품 수정
	@RequestMapping(value = "/updateItems", method = RequestMethod.POST)
	public void updateItems(MyItemsBoardVO myItemsBoardVO) {

		logger.info("updateItems Start" + myItemsBoardVO.toString());
		myItems.updateItems(myItemsBoardVO);

	}

	// 카메라닉네임 리턴
	@RequestMapping(value = "/cameraNickInfo", method = RequestMethod.POST)
	public List<CameraAndTimelapseInfoVO> cameraNickInfo(String memberId) {
		logger.info("cameraNickInfo Start: ");

		return myItems.getCameraNick(memberId);
	}

	// 카메라넘버에 따른 타임랩스 데이터리스트!! 리턴 (cameraNo, pageNum를 인자로 받는다)
	@RequestMapping(value = "/timelapseInfo/{page}/{cameraNo}", method = RequestMethod.GET)
	public Map<String, Object> timelapseInfo(PageMaker pageMaker) {
		logger.info("TimelapseInfo Start:" + pageMaker.toString());

		// 리스트 갯수 선택
		pageMaker.setPerListNum(5);
		// 페이징 숫자 선택
		pageMaker.setPerPageNum(5);

		return myItems.getTimelapseInfo(pageMaker);
	}

	// 하나의 타임랩스 데이터 리턴
	@RequestMapping(value = "/timelapsData", method = RequestMethod.POST)
	public TimeLapseVO timelapsData(@RequestBody TimeLapseVO timeLapseVO) {
		logger.info("timeLapseVO Start: " + timeLapseVO.toString());

		return myItems.timelapsData(timeLapseVO);
	}
	
	
	// QR코드 서버업데이트
	@RequestMapping(value = "/qrinfoupdate", method = RequestMethod.POST)
	public void qrInfoUpdate(@RequestBody TimeLapseVO vo) throws Exception {
		
		logger.info("START qrInfoUpdate"+vo.toString());
		service.qrInfoUpdate(vo);
		
	}
	
	@RequestMapping(value = "mobileData/{itemNo}", method = RequestMethod.GET)
	public Map<String, Object> mobileviewData(MyItemsBoardVO myItemsBoardVO){
		logger.info("mobileviewData Start: " + myItemsBoardVO.toString());
		
		return myItems.getMobileviewData(myItemsBoardVO);
	}
}
