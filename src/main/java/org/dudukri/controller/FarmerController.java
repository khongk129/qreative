package org.dudukri.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.dudukri.domain.CameraVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.service.CameraService;
import org.dudukri.service.TimeLapseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/farmer/")
public class FarmerController {

	private static Logger logger = LoggerFactory.getLogger(FarmerController.class);

	@Inject
	private TimeLapseService service;

	@Inject
	private CameraService cameraService;

	// 영상확인 페이지 리스트
	@RequestMapping(value = "/main/{memberId}", method = RequestMethod.GET)
	public List<TimeLapseVO> TimeRead(@PathVariable String memberId) {

		List<TimeLapseVO> list = service.read(memberId);

		return list;
	}

	// 화면 생성
	@RequestMapping(value = "/timecreate", method = RequestMethod.POST)
	public void TimeCreate(@RequestBody TimeLapseVO vo) {
		System.out.println("넘어옴?");
		int num = cameraService.cameraNumCheck(vo);
		vo.setCameraNo(num);
		vo.setTimeName("작물명을 입력하세요");
		vo.setTimeImgPath("/temp/img.jpg");
		vo.setImgCurTime("촬영시작전입니다");
		vo.setTimeVideoPath("/temp/video.mp4");
		vo.setTimeStart("시작일");
		vo.setTimeEnd("종료일");
		vo.setTemp(0);
		vo.setHumidity(0);
		vo.setTimeStatus(false);
		service.timeCreate(vo);
	}

	// 작물명변경
	@RequestMapping(value = "/timenamemodify", method = RequestMethod.POST)
	public void TimeModify(@RequestBody TimeLapseVO vo) {

		service.timeNameModify(vo);

	}

	// 카메라 닉네임 변경
	@RequestMapping(value = "/cameranickmodify", method = RequestMethod.POST)
	public void NickModify(@RequestBody TimeLapseVO vo) {

		service.cameraNickModify(vo);

	}

	// 인코딩하기
	@RequestMapping(value = "/encoding", method = RequestMethod.POST)
	public String encoding(@RequestBody TimeLapseVO vo) throws Exception {

		System.out.println("vo는?"+vo);
		
		String strStart = vo.getTimeStart();
		String strEnd = vo.getTimeEnd();

		logger.info(strStart);
		logger.info(strEnd);
		// custom 폴더 생성
		String customDir = "c:\\java\\upload\\" + vo.getMemberId() + "\\data\\" + vo.getCameraId() + "\\video\\custom\\";
		File custom = new File(customDir);
		if (!custom.exists()) {
			custom.mkdirs();
		}

		// txt 폴더생성
		String targetDir = "c:\\java\\upload\\" + vo.getMemberId() + "\\data\\" + vo.getCameraId() + "\\video\\txt\\";
		File txtDir = new File(targetDir);
		if (!txtDir.exists()) {
			txtDir.mkdirs();
		}

		// MP4 저장위치
		String totalFile = "c:\\java\\upload\\" + vo.getMemberId() + "\\data\\" + vo.getCameraId() + "\\video\\custom\\"
				+ vo.getTimeStart() + "~" + vo.getTimeEnd() + ".mp4";

		// txt 저장위치
		String txtName = "c:\\java\\upload\\" + vo.getMemberId() + "\\data\\" + vo.getCameraId() + "\\video\\txt\\"
				+ vo.getTimeNo() + ".txt";
		File txtFile = new File(txtName);

		// DB 저장위치값
		String timeVideoPath = "\\"+ vo.getMemberId() + "\\data\\" + vo.getCameraId() + "\\video\\custom\\"+ vo.getTimeStart() + "~" + vo.getTimeEnd() +".mp4";
		vo.setTimeVideoPath(timeVideoPath);

		// 날자 데이터를 Date 폼으로 변경
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = df.parse(strStart);
		Date d2 = df.parse(strEnd);

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(d1);
		c2.setTime(d2);

		
		//로고 넣으면 txt 파일이 삭제안되니 확인하고.
		/*String demo =  "file 'c:\\java\\upload\\temp\\logo.mp4' \r\n";
		FileWriter fiw = new FileWriter(txtName, true);
		fiw.write(demo);
		fiw.flush();*/


		while (c1.compareTo(c2) != 1) {

			// 중간날짜 구하기
			String encodingDay = String.format("%tF", c1.getTime());
			c1.add(Calendar.DATE, 1);

			// txt 내용
			String txt = "file 'c:\\java\\upload\\" + vo.getMemberId() + "\\data\\" + vo.getCameraId() + "\\"
					+ "video\\oneday\\" + encodingDay + ".mp4'\r\n";

			// txt에 내용쓰기
			FileWriter fw = new FileWriter(txtName, true);
			fw.write(txt);
			fw.flush();
			fw.close();
		}

		// txt에 등록된 동영상 하나로 모으기
		ProcessBuilder pb = new ProcessBuilder("c:\\ffmpeg\\bin\\ffmpeg.exe", "-f", "concat", "-safe", "0", "-y", "-i",
				txtName, "-c", "copy", totalFile);

		// 프로세스 실행
		pb.redirectErrorStream(true); // 에러출력을 정상출력과 같게

		Process p = pb.start();

		long start = System.currentTimeMillis();

		// 표준출력 상태를 출력
		BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String statusCheck = null;
		while ((statusCheck = stdOut.readLine()) != null) {
			System.out.println(statusCheck);
		}

		// txt 폴더 삭제
		txtFile.delete();
		txtDir.delete();
		
		int i = p.waitFor(); // 0 이면 정상종료

		

		System.out.println("결과 : " + i + " (0이면 정상종료)");
		System.out.println("처리 시간 : " + (System.currentTimeMillis() - start) / 1000 + "초");

		if (0 != i) {
			System.out.println("명령 오류 : << " + i + " >>");
			p.destroy();
			return "1";
		} else {
			System.out.println("처리 완료");
			//service.timeCount(vo);
			service.encoding(vo);
			p.destroy();
			return "0";
		}

	}

	// 사진파일 동영상파일 화면출력
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		logger.info("START displayFile get..");

		String lowFileName = fileName.toLowerCase();
		String file;

		logger.info("lowFileName: " + lowFileName);

		HttpHeaders headers = new HttpHeaders();

		if (lowFileName.indexOf(".mp4") > -1) {
			logger.info("mp4");
			headers.set("Content-Type", "video/mpeg; charset=UTF-8");
			file = "C:\\Java\\upload" + fileName;
		} else if (lowFileName.indexOf(".jpg") > -1) {
			logger.info("jpg");
			headers.setContentType(MediaType.IMAGE_JPEG);
			file = "C:\\Java\\upload" + fileName;
			logger.info("fileName: " + file);
		}else if(lowFileName.indexOf(".png") >-1){
			logger.info("png");
			headers.setContentType(MediaType.IMAGE_PNG);
			file = "C:\\Java\\upload" + fileName;
			logger.info("fileName: "+file);;
		}else {
			logger.info("else");
			headers.setContentType(MediaType.IMAGE_JPEG);

			File[] fileList = new File("C:\\Java\\upload" + fileName).listFiles();
			int fileLength = fileList.length;
			String imgFileName = fileList[fileLength - 2].getName();
			file = "C:\\Java\\upload" + fileName + "\\" + imgFileName;
			logger.info("else: " + file);
			logger.info("fileLength: " + fileLength);
			logger.info("imgFileName: " + imgFileName);
		}

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(new FileInputStream(file)), headers, HttpStatus.OK);
	}

	// 과거영상 리스트
	@RequestMapping(value = "/history/{memberId}", method = RequestMethod.GET)
	public Map<String, Object> history(@PathVariable String memberId) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<TimeLapseVO> list = service.viewHistory(memberId); // List 쿼리문

		map.put("list", list);

		return map;
	}

}
