package org.dudukri.service;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.persistence.CameraDAO;
import org.dudukri.util.CameraPageMaker;
import org.springframework.stereotype.Service;

@Service
public class CarmeraServiceImpl implements CameraService{

	@Inject
	CameraDAO dao;
	
	
	@Override
	public List<CameraVO> listRead(CameraPageMaker pagemaker) {

		int page = pagemaker.getPage();
		
		return dao.read(pagemaker);
	}

	
	@Override
	public void nickUpdate(CameraVO vo) {
		
		dao.nickUpdate(vo);
	}


	@Override
	public void timerUpdate(CameraVO vo) {
		
		dao.timerUpdate(vo);
	}


	@Override
	public void RegisterCamera(CameraVO vo) {

		dao.registerCamera(vo);
	}


	@Override
	public void deleteCamera(int cno) {
		
		dao.deletedCamera(cno);
	}


	@Override
	public int getCount(String memberId) {
		
		return dao.getCount(memberId);
	}

	@Override
	public CameraVO read(int cno) {
		
		return dao.read(cno);
	}


	@Override
	public List<CameraVO> listRead() {
		
		return dao.listRead();
	}

	@Override
	public void statusUpdate(CameraVO vo) {
		
		dao.statusUpdate(vo);
	}
	
	@Override
	public int cameraNumCheck(TimeLapseVO vo) {
		return dao.cameraNumCheck(vo);
	}


	@Override
	public Boolean idCheck(String cameraId) {
		
		return dao.idCheck(cameraId);
	}


	@Override
	public CameraVO idRead(String cameraId) {
		
		return dao.idRead(cameraId);
	}
}
