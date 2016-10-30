package org.dudukri.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.CameraAndTimelapseInfoVO;
import org.dudukri.domain.MyItemsBoardVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.persistence.MyItemsBoardDAO;
import org.dudukri.persistence.TimeLapseDAO;
import org.dudukri.util.FileUpDown;
import org.dudukri.util.ImageResizing;
import org.dudukri.util.PageMaker;
import org.dudukri.util.PathToPathList;
import org.dudukri.util.QRMaker;
import org.springframework.stereotype.Service;

@Service
public class MyItemsBoardServiceImpl implements MyItemsBoardService {

	@Inject
	private MyItemsBoardDAO myItems;
	
	@Inject
	private TimeLapseDAO dao;
	
	@Override
	public void insertItems(MyItemsBoardVO myItemsBoardVO) {

		myItems.insertItems(myItemsBoardVO);
		
		List<MyItemsBoardVO> myItemsBoardVOByTimeNo =  myItems.itemBytimeNo(myItemsBoardVO);
		
		myItemsBoardVO.setItemNo(myItemsBoardVOByTimeNo.get(0).getItemNo());
		System.out.println("itemNo: "+myItemsBoardVOByTimeNo.get(0).getItemNo());
		System.out.println("myItemsBoardVO: "+myItemsBoardVO.toString());
		
		FileUpDown fud = new FileUpDown();
		ImageResizing imgResize = new ImageResizing();

		fud.downLoadToDB(myItemsBoardVO);
		imgResize.imageResizing(myItemsBoardVO);
		
		//타임랩스 정보 DB에 업로드 
		TimeLapseVO timeLapseVO = new TimeLapseVO();
		timeLapseVO.setItemNo(myItemsBoardVOByTimeNo.get(0).getItemNo());
		timeLapseVO.setTimeNo(myItemsBoardVOByTimeNo.get(0).getItemNo());
		timeLapseVO.setCertNum(myItemsBoardVO.getCertNum());
		timeLapseVO.setDeliNum(myItemsBoardVO.getDeliNum());
		timeLapseVO.setTimeImgPath(myItemsBoardVO.getTimeImgPath());
		//timeLapseVO.setTimeStatus(1);
		
		QRMaker qr = new QRMaker();
		qr.qrMaker(timeLapseVO);
		myItems.updateItems(myItemsBoardVO);
		dao.qrInfoUpdate(timeLapseVO);
		
	}

	@Override
	public void updateItems(MyItemsBoardVO myItemsBoardVO) {

		if (myItemsBoardVO.getItemImgFile() != null) {
			FileUpDown fud = new FileUpDown();
			ImageResizing imgResize = new ImageResizing();

			fud.downLoadToDB(myItemsBoardVO);
			imgResize.imageResizing(myItemsBoardVO);
		}

		myItems.updateItems(myItemsBoardVO);
	}

	@Override
	public Map<String, Object> listItems(PageMaker pageMaker) {

		Map<String, Object> itemsMap = new HashMap<>();

		pageMaker.setTotalCount(count(pageMaker.getMemberId()));
		pageMaker.calcPage();

		List<MyItemsBoardVO> listItems = myItems.listItems(pageMaker);
		List<TimeLapseVO> listTime = new ArrayList<>();
		
		TimeLapseVO timeVO = new TimeLapseVO();
		PathToPathList pathMake = new PathToPathList();
		
		for (MyItemsBoardVO myItemsBoardVO : listItems) {
			timeVO.setTimeNo(myItemsBoardVO.getTimeNo());
			
			//PathToPathList로 이미지나 비디오 Dir경로에서 fileList를 가져온다
			myItemsBoardVO.setPathList(pathMake.pathList(myItemsBoardVO.getItemThumbImgPath()));
			listTime.add(myItems.timelapsData(timeVO));
		}

		itemsMap.put("listItems", listItems);
		itemsMap.put("listTime", listTime);
		itemsMap.put("pageMaker", pageMaker);

		return itemsMap;
	}

	@Override
	public MyItemsBoardVO viewItems(MyItemsBoardVO myItemsBoardVO) {

		return myItems.viewItems(myItemsBoardVO);
	}

	@Override
	public int count(String memberId) {
		return myItems.count(memberId);
	}

	@Override
	public void deleteItems(List<String> itemNo) {

		myItems.deleteItems(itemNo);
	}

	@Override
	public TimeLapseVO timelapsData(TimeLapseVO timeLapseVO) {
		return myItems.timelapsData(timeLapseVO);
	}

	@Override
	public List<CameraAndTimelapseInfoVO> getCameraNick(String memberId) {
		return myItems.getCameraNick(memberId);
	}

	// 페이징과 함께 실시!!
	@Override
	public Map<String, Object> getTimelapseInfo(PageMaker pageMaker) {

		Map<String, Object> timeMap = new HashMap<>();

		pageMaker.setTotalCount(myItems.timelapseCount(pageMaker));
		pageMaker.calcPage();

		List<CameraAndTimelapseInfoVO> timeList = myItems.getTimelapseInfo(pageMaker);

		timeMap.put("timeList", timeList);
		timeMap.put("pageMaker", pageMaker);

		return timeMap;
	}
	
	@Override
	public Map<String, Object> getMobileviewData(MyItemsBoardVO myItemsBoardVO) {
		
		Map<String, Object> itemAndTimeMap = new HashMap<>();
		TimeLapseVO timeLapseVO = new TimeLapseVO();
		
		
		timeLapseVO.setTimeNo(myItemsBoardVO.getTimeNo());
		
		TimeLapseVO timelapseData = myItems.timelapsData(timeLapseVO);
		MyItemsBoardVO itemData = myItems.viewItems(myItemsBoardVO);
		
		
		itemAndTimeMap.put("timelapseData", timelapseData);
		itemAndTimeMap.put("itemData", itemData);
		
		
		return itemAndTimeMap;
	}


}
