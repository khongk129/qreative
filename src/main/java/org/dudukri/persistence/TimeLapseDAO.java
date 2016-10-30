package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.TimeLapseVO;

public interface TimeLapseDAO {
	
	public void timeNameModify(TimeLapseVO vo);
	
	public void cameraNickModify(TimeLapseVO vo);
	
	public void encoding(TimeLapseVO vo);
	
	public void timeCount(TimeLapseVO vo);
	
	public void timeCreate(TimeLapseVO vo);
	
	public List<TimeLapseVO> read(String memberId);
	
	public void qrInfoUpdate(TimeLapseVO vo);
	
	public void qrPathUpdate(TimeLapseVO vo);
	
	public List<TimeLapseVO> viewHistory(String memberId);
	
	public TimeLapseVO checkCameraId(String cameraId);
	
	public void timeImgPathModify(TimeLapseVO vo);
	
	public void timeStatus(TimeLapseVO vo);
}
