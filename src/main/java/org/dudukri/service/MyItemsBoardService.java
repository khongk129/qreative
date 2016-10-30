package org.dudukri.service;


import java.util.List;
import java.util.Map;

import org.dudukri.domain.CameraAndTimelapseInfoVO;
import org.dudukri.domain.MyItemsBoardVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.util.PageMaker;

public interface MyItemsBoardService {

	public void insertItems(MyItemsBoardVO myItemsBoardVO);
	public Map<String, Object> listItems(PageMaker pageMaker);
	public MyItemsBoardVO viewItems(MyItemsBoardVO myItemsBoardVO);
	public int count(String memberId);
	public void deleteItems(List<String> itemNo);
	public void updateItems(MyItemsBoardVO myItemsBoardVO);
	public TimeLapseVO timelapsData(TimeLapseVO timeLapseVO);
	public List<CameraAndTimelapseInfoVO> getCameraNick(String memberId);
	public Map<String, Object> getTimelapseInfo(PageMaker pagemaker);
	public Map<String, Object> getMobileviewData(MyItemsBoardVO myItemsBoardVO);
}
