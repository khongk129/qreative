package org.dudukri.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.RaspberryVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.persistence.TimeLapseDAO;
import org.dudukri.util.FileSave;
import org.springframework.stereotype.Repository;

@Repository
public class TimeLapseServiceImpl implements TimeLapseService {

	@Inject
	TimeLapseDAO dao;


	@Override
	public List<TimeLapseVO> read(String memberId) {

		return dao.read(memberId);
	}


	@Override
	public void timeNameModify(TimeLapseVO vo) {
		dao.timeNameModify(vo);
	}


	@Override
	public void cameraNickModify(TimeLapseVO vo) {
		dao.cameraNickModify(vo);
	}


	@Override
	public void encoding(TimeLapseVO vo) {
		dao.encoding(vo);
	}

	@Override
	public void qrInfoUpdate(TimeLapseVO vo) {
		dao.qrInfoUpdate(vo);
	}

	@Override
	public void qrPathUpdate(TimeLapseVO vo) {
		dao.qrPathUpdate(vo);
	}

	@Override
	public List<TimeLapseVO> viewHistory(String memberId) {
		return dao.viewHistory(memberId);
	}

	@Override
	public void timeCount(TimeLapseVO vo) {
		dao.timeCount(vo);
	}

	@Override
	public void timeCreate(TimeLapseVO vo) {
		dao.timeCreate(vo);
	}
	
	
	//서버컴퓨터에 사진 저장, DB에 상태정보 저장
	@Override
	public void raspTransData(RaspberryVO raspberryVO) {

		FileSave fs = new FileSave();
		
		String fileName = raspberryVO.getFile().getOriginalFilename();
		
		String cameraId = raspberryVO.getRaspID();
		
		//DB camera 테이블에서 ID 체크
		TimeLapseVO timeLapseVO = dao.checkCameraId(cameraId);
		
		//카메라 ID가 존재X 리턴
		if(timeLapseVO.getMemberId()==null||timeLapseVO.getMemberId()==""){
			
			System.out.println("카메라ID 존재 X");
			return;
		}
		
		
		
		raspberryVO.setMemberId(timeLapseVO.getMemberId());	
		String filePath= "\\"+raspberryVO.getMemberId()+ "\\data\\" + raspberryVO.getRaspID() + "\\img\\"+ raspberryVO.getYear() + "\\" + raspberryVO.getMonth() + "\\" + raspberryVO.getDay();
		String dirPath = "\\"+raspberryVO.getMemberId()+ "\\data\\" + raspberryVO.getRaspID() + "\\img";

		File checkDir = new File("c:\\java\\upload"+dirPath);
		
		
		
		String imgCurTime = raspberryVO.getYear()+"/"+raspberryVO.getMonth()+"/"+raspberryVO.getDay()+"   "+raspberryVO.getHour()+":"+raspberryVO.getMinute();
		//DB에 저장할 데이터 셋팅!!
		timeLapseVO.setTimeImgPath(filePath);
		timeLapseVO.setTemp(raspberryVO.getTemperature());
		timeLapseVO.setHumidity(raspberryVO.getHumidity());
		timeLapseVO.setImgCurTime(imgCurTime);
		
		dao.timeImgPathModify(timeLapseVO);
		
		try {
			
			if (fileName.indexOf(".log") != -1){
				//log save
				fs.saveLog(raspberryVO);
			}

			//사진 저장 & 인코딩
			fs.saveFile(raspberryVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void timeStatus(TimeLapseVO vo) {
		dao.timeStatus(vo);
	}
}
