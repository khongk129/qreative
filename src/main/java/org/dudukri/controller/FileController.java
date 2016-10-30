package org.dudukri.controller;

import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.RaspberryVO;
import org.dudukri.service.TimeLapseService;
import org.dudukri.util.FileSave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@Controller
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Inject
	private TimeLapseService service;
	
	
	
	//15일 인코딩 스트링
	@RequestMapping(value = "/fifteen", method = RequestMethod.GET) 
	public void	fifteenEncoding(String day) throws Exception{
		logger.info("Start fifteneEncoding Controller");
		
	}


	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public ResponseEntity<String> saveFile(Map<String, Object> rasp) throws Exception {
		
		logger.info("Start saveFile Controller");
		
		
		System.out.println(rasp.get(0));

		return null;
	}
	
	
	/*@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<String> saveFile(RaspberryVO rasp) throws Exception {
		
		logger.info("Start saveFile Controller");
		
		FileSave fs = new FileSave();
		
		MultipartFile file = rasp.getMultipartFile();
		
		logger.info("파일이름: "+file.getOriginalFilename());
		logger.info("온도: "+rasp.getTemperature());
		logger.info("습도: "+rasp.getHumidity());
		
		//log save
		if (file.getOriginalFilename().indexOf(".log") != -1){
			fs.saveLog(file);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		
		//사진 저장 & 인코딩
		fs.saveFile(file);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/plain; charset=UTF-8");
		
		return new ResponseEntity<String>(file.getOriginalFilename(), responseHeaders, HttpStatus.OK);
	}*/
	
	@ResponseBody
	@RequestMapping(value = "/imgFile", method = RequestMethod.POST)
	public ResponseEntity<String> saveFile(MultipartFile file, float temperature, float humidity) throws Exception {
		
		logger.info("Start saveFile Controller");
		
		logger.info("파일이름: "+file.getOriginalFilename());
		logger.info("온도: "+temperature);
		logger.info("습도: "+humidity);
		
		RaspberryVO vo = new RaspberryVO();
				
		vo.setMultipartFile(file);
		vo.setTemperature(temperature);
		vo.setHumidity(humidity);
		
		service.raspTransData(vo);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/plain; charset=UTF-8");
		
		return new ResponseEntity<String>(file.getOriginalFilename(), responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String ID, String password){
		
		logger.info("login");
		
		logger.info(ID+" : "+password);
		
		return "/main";
		
	}

}
