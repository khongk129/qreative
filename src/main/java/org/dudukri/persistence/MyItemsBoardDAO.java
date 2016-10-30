package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.CameraAndTimelapseInfoVO;
import org.dudukri.domain.MyItemsBoardVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.util.PageMaker;

public interface MyItemsBoardDAO {

	public void insertItems(MyItemsBoardVO myItemsBoardVO);
	public List<MyItemsBoardVO> listItems(PageMaker pageMaker);
	public MyItemsBoardVO viewItems(MyItemsBoardVO myItemsBoardVO);
	public int count(String memberId);
	public void deleteItems(List<String> itemNo);
	public void updateItems(MyItemsBoardVO myItemsBoardVO);
	public TimeLapseVO timelapsData(TimeLapseVO timeLapseVO);
	public List<CameraAndTimelapseInfoVO> getCameraNick(String memberId);
	public List<CameraAndTimelapseInfoVO> getTimelapseInfo(PageMaker pagemaker);
	public int timelapseCount(PageMaker pagemaker);
	public List<MyItemsBoardVO> itemBytimeNo(MyItemsBoardVO myItemsBoardVO);
	
}
