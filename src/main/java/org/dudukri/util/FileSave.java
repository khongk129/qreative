package org.dudukri.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.apache.commons.io.IOUtils;
import org.dudukri.domain.RaspberryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileSave {

	private static final String UPLOAD_DIR = "c:\\java\\upload";
	private static final Logger logger = LoggerFactory.getLogger(FileSave.class);
	private static File targetDir;
	private static String OrigFileName;


	// log파일 저장
	public void saveLog(RaspberryVO raspberryVO) throws Exception {
		
		String fileName = raspberryVO.getFile().getOriginalFilename();
		
		logger.info("Start log Save: "+ raspberryVO.getFile().getOriginalFilename());
		
		String logDirName = UPLOAD_DIR +"\\"+raspberryVO.getMemberId()+"\\log\\rasp";
		File logDir = new File(logDirName);
		
		if (!logDir.exists()) { // 확인 (없으면)
			logDir.mkdirs(); //폴더만들기
		}

		
		String outputDir = logDir +"/"+ fileName;
		FileOutputStream fos = new FileOutputStream(outputDir);
		IOUtils.copy(raspberryVO.getFile().getInputStream(), fos);
		fos.close();
		return;
	}

	// 사진파일 저장
	public String saveFile(RaspberryVO vo) throws Exception {
		MultipartFile file = vo.getMultipartFile();
		
		OrigFileName =vo.getOrigiFilename();
		logger.info("Start Img Save: "+ OrigFileName);
		
		
		String fileTarget = vo.getMemberId()+ "\\data\\" + vo.getRaspID() + "/img/" + vo.getYear() + "/" + vo.getMonth() + "/" + vo.getDay();
		// 경로 잡아주고
		targetDir = new File(UPLOAD_DIR +"\\"+fileTarget);

		// 디렉토리가 없으면 생성
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		
		// 사진파일 저장
		FileOutputStream fos = new FileOutputStream(targetDir + "/" + OrigFileName);
		IOUtils.copy(file.getInputStream(), fos);
		fos.close();
		renameFile(vo);
		
		// 인코딩
		if (OrigFileName.indexOf(".jpg") != -1 && Integer.parseInt(vo.getHour()) >= 23 && Integer.parseInt(vo.getMinute()) >= 49) {
			
			encodingFile(vo);
		}

		return fileTarget;
	}

	
	// 23시 jpg파일 mp4로 인코딩
	public void encodingFile(RaspberryVO vo) throws Exception {
		
		logger.info("Start 23 encoding ");
			FFmpegEncoder ffmaker = new FFmpegEncoder();
			ffmaker.ffmpegMaker(vo);
			return;
	}
	
	
	//사진파일 이름 변경
	public void renameFile(RaspberryVO vo) throws Exception{
		
		logger.info("Start renameFile ");
		if (!targetDir.exists() || !targetDir.isDirectory()) {
			logger.info("유효하지 않은 디렉토리입니다.");
			return;
		}

		File[] flist = targetDir.listFiles();
		int count = 1;
		
		for (int i = 0; i < flist.length; i++) {
			
			String fileName = flist[i].getName();
			
			//jpg 파일만 이름 변경
			if(fileName.indexOf(".jpg") != -1){
				//지금 들어온 파일만 텍스트 파일에 저장
				if(flist[i].getName().equals(OrigFileName)){
					
					String newFileName = "0000"+ (count) + fileName.substring(fileName.length()-4);
					newFileName = newFileName.substring(newFileName.length() - 7);
					
					infoText(newFileName, vo);
				}
				
			// 파일명
			String newFileName = "0000"+ (count) + fileName.substring(fileName.length()-4);
			newFileName = newFileName.substring(newFileName.length() - 7);

			String renameFile=targetDir+"/"+newFileName;

			//folderName+newFileName
			flist[i].renameTo(new File(renameFile));
			
			
			count++;
			}
			else{
				count--;
			}
		}//end for
	}//end renameFile()

	//온도, 습도, 사진1장 저장
	 public void infoText(String fname, RaspberryVO vo) {
		 
		 	logger.info("Start infoText");
         
	        String txt = "파일: "+targetDir+"\\"+fname+", 시간: "+vo.getHour()+"시 "+vo.getMinute()+"분"+", 온도: "+vo.getTemperature()+", 습도: "+vo.getHumidity();
	         
	        String fileName = targetDir +"\\t"+vo.getYear()+vo.getMonth()+vo.getDay()+".txt" ;
	         
	         
	        try{
	                         
	            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
	            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	             
	            // 파일안에 문자열 쓰기
	            fw.write(txt);
	            fw.newLine();
	            fw.flush();
	 
	            // 객체 닫기
	            fw.close(); 
	             
	             
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	         
	 
	    }
	
}