package org.dudukri.service;

import java.util.List;

import org.dudukri.domain.RaspberryVO;
import org.dudukri.domain.TimeLapseVO;

public interface TimeLapseService {

	public void timeNameModify(TimeLapseVO vo);
	
	public void cameraNickModify(TimeLapseVO vo);
	
	public void encoding(TimeLapseVO vo);
	
	public void timeCount(TimeLapseVO vo);
	
	public void timeCreate(TimeLapseVO vo);
	
	public List<TimeLapseVO> read(String memberId);
	
	public void qrInfoUpdate(TimeLapseVO vo);

	public void qrPathUpdate(TimeLapseVO vo);
	
	public List<TimeLapseVO> viewHistory(String memberId);
	
	public void raspTransData(RaspberryVO raspberryVO);
	
	public void timeStatus(TimeLapseVO vo);
}
