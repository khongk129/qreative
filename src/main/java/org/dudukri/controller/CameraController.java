package org.dudukri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.service.CameraService;
import org.dudukri.service.SerialService;
import org.dudukri.service.TimeLapseService;
import org.dudukri.util.CameraPageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.Result;

@CrossOrigin
@Controller

public class CameraController {

	@Inject
	TimeLapseService timeService;
	
	@Inject
	CameraService service;
	
	@Inject
	SerialService serialService;

	
	private static Logger logger = LoggerFactory.getLogger(CameraController.class);
	private static int statusSignal = 0;
	private static int timerSignal = 0;
	private static int cameraNo = 0;

	// List를 사용하려면 ResponseBody사용
	// 리스트 페이징
	@ResponseBody
	@RequestMapping(value = "/list/{memberId}/{page}", method = RequestMethod.GET)
	public Map<String, Object> hash(@PathVariable("memberId") String memberId, @PathVariable("page") int page) {

		logger.info("memberId =" + memberId);
		logger.info("page = " + page);

		CameraPageMaker pagemaker = new CameraPageMaker();
		pagemaker.setMemberId(memberId);
		pagemaker.setCurPage(page);
		int count = service.getCount(memberId);
		pagemaker.setCount(count);
		pagemaker.calcPage();

		Map<String, Object> map = new HashMap<String, Object>();

//		logger.info(pagemaker.toString());
		List<CameraVO> list = service.listRead(pagemaker);

//		logger.info(list.toString());

		map.put("list", list);
		map.put("page", pagemaker);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/updateNick", method = RequestMethod.POST)
	public void updateNickName(@RequestBody CameraVO vo) {

		// param으로 버튼이 눌러진 카메라 번호, input값 을 받는다.
		logger.info("Start update()");
		
		int cno = vo.getCameraNo();
		String cameraNick = vo.getCameraNick();

		vo = service.read(cno);
		
		// param외에 다른값을 카메라번호로 조회하여 값을 받는다.
//		List<CameraVO> list = new ArrayList<>();
//		list = service.listRead();
//		vo = list.get(vo.getCameraNo()-1); // 변경할 카메라 번호에서 나머지 정보를 가져옴.
		
		vo.setCameraNo(cno);
		vo.setCameraNick(cameraNick);
		
		logger.info("vo.tostring = "+vo.toString());
		
		service.nickUpdate(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateTimer", method = RequestMethod.POST)
	public void updateTimer(@RequestBody CameraVO vo) {

		// param으로 버튼이 눌러진 카메라 번호, input값 을 받는다.
		logger.info("Start updateTimer()");
		
		int cno = vo.getCameraNo();
		int cameraTimer = vo.getCameraTimer();
		cameraNo = vo.getCameraNo();
		
		logger.info(vo.toString());
		
//		// param외에 다른값을 카메라번호로 조회하여 값을 받는다.
		
		vo.setCameraNo(cno);
		vo.setCameraTimer(cameraTimer);
		
		logger.info("(updateTimer) vo.tostring = "+vo.toString());
		
		service.timerUpdate(vo);
		timerSignal = 1;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cameraRegister", method = RequestMethod.POST)
	public int registerCamera(@RequestBody CameraVO vo){
		
		int result = 0;
		Boolean tbl_serialCheck = false;
		Boolean tbl_cameraCheck = false;
		
		logger.info("Start registerCamera");
		logger.info("(registerCamera) vo.tostring = "+vo.toString());
		
		String cameraId = vo.getCameraId();						// 파라미터로 들어온 vo에서 Id값을 추출.
		logger.info("cameraID =" +cameraId);
		
		tbl_serialCheck = serialService.serialidRead(cameraId);	// tbl_serial 테이블에 입력 한 SerialId값을 조회.
		logger.info("idCheck value = "+tbl_serialCheck);
		
	 // Serial 테이블에 등록되어있는 Serial 번호.
		if( tbl_serialCheck == true){
			
			tbl_cameraCheck = service.idCheck(cameraId);	// Camera 테이블에 이미 등록되어있는지 Check.
			
			// Camera 테이블에 이미 등록되어 있을 시,
			if( tbl_cameraCheck == true){
				
				result = 1; // Camera 테이블에 이미 등록 되어있음.
				return result;
			}
			
			// 등록 진행.
			logger.info("camera is not exist");
			service.RegisterCamera(vo);
			
			result = 0;
			return result;
		}
		
		// Serial테이블에 등록이 안되어있다.
		result = 2;
		
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cameraDelete", method = RequestMethod.POST)
	public void deleteCamera(@RequestBody int[] cameraNo){
		
		logger.info("START deleteCamera");
		
		for( int i = 0; i < cameraNo.length; i++){
			
			logger.info("cameraNo = "+cameraNo[i]);
			
			service.deleteCamera(cameraNo[i]);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cameraPower", method = RequestMethod.POST)
	public void cameraPower(@RequestBody CameraVO vo, String cameraId){
		
		logger.info("START cameraPower");
		
		TimeLapseVO tvo = new TimeLapseVO();
		// 카메라번호를 받아서 시리얼번호를 얻어와야한다. 
			
		int cno = vo.getCameraNo();
		logger.info(""+cno);
		
		String status = vo.getCameraStatus();
		logger.info("status = "+status);
		
		// 상태값 업데이트 해야한다.
		service.statusUpdate(vo);
		
		vo = service.read(cno);
		logger.info(vo.toString());
		
		statusSignal = 1;
		
		if(status.equals("정상")){
			
			tvo.setTimeStatus(true);
			tvo.setCameraNo(cno);
			timeService.timeStatus(tvo);
			
		}else{
			tvo.setTimeStatus(false);
			tvo.setCameraNo(cno);
			timeService.timeStatus(tvo);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cameraStatus", method = RequestMethod.POST)
	public String cameraStatus(String cameraId){
		
		// 라즈베리파이에서 시리얼번호를 보내면 
		logger.info("cameraId = "+cameraId);

		CameraVO vo = service.idRead(cameraId);
		logger.info("TEST = "+vo.toString());
		logger.info("cameraStatus = "+vo.getCameraStatus());
		
		if(vo.getCameraStatus().equals("종료")){
			
			logger.info("TEST IF");
			String str = "shutdown";
			return str;
		}
		
		if (statusSignal == 1 ){
			
			logger.info("START IF");
			vo = service.read(cameraNo);
			cameraId = vo.getCameraId();
			
			statusSignal = 0;
			
			return cameraId;
		}
		
		if (timerSignal == 1){
			
			logger.info("START timerSignal");
			
			vo = service.read(cameraNo);
			int temp = vo.getCameraTimer();
			String cameraTimer = ("time="+ temp);
			
			return cameraTimer;
		}
		
		return null;
	}
}
