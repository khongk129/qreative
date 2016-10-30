package org.dudukri.service;

import java.util.List;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.util.CameraPageMaker;


public interface CameraService {

	public CameraVO idRead(String cameraId);
	public Boolean idCheck(String cameraId);
	
	public CameraVO read(int cno);
	public List<CameraVO> listRead();
	public List<CameraVO> listRead(CameraPageMaker pagemaker);
	
	public void nickUpdate(CameraVO vo);
	public void timerUpdate(CameraVO vo);
	public void RegisterCamera(CameraVO vo);
	public void deleteCamera(int cno);
	public void statusUpdate(CameraVO vo);
	
	public int getCount(String memberId);
	public int cameraNumCheck(TimeLapseVO vo);
}
