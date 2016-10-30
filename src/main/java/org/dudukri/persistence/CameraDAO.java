package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.util.CameraPageMaker;

public interface CameraDAO {

	public CameraVO read(int cno);
	public CameraVO idRead(String cameraId);
	public Boolean  idCheck(String cameraId);
	public List<CameraVO> listRead();
	public List<CameraVO> read(CameraPageMaker pagemaker);
//	public List<CameraVO> read(int page);
	
	public void statusUpdate(CameraVO vo);
	public void nickUpdate(CameraVO vo);
	public void timerUpdate(CameraVO vo);
	public void registerCamera(CameraVO vo);
	public void deletedCamera(int cno);
	public int getCount(String memberId);
	public int cameraNumCheck(TimeLapseVO vo);
}
