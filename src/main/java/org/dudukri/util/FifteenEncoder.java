package org.dudukri.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.dudukri.domain.TimeLapseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FifteenEncoder {

	private static final Logger logger = LoggerFactory.getLogger(FifteenEncoder.class);

	public void saveFifteen(TimeLapseVO vo) throws Exception {

		logger.info("Start saveFifteen ");

		// MP4 저장위치
		String totalFile = "c:\\zzz\\data\\"+ vo.getMemberId() + "\\" + vo.getCameraId() + 
						   "\\video\\custom\\"+ vo.getTimeStart() + "~" + vo.getTimeEnd() +".mp4";
		
		// txt 파일 만들기
		String txtName = "c:\\java\\update\\" + vo.getMemberId() + "\\" + vo.getCameraId() + 
						 "\\video\\txt\\" + vo.getTimeNo() + ".txt";
		File txtFile = new File(txtName);

		// 인코딩 시작일 . 마지막일
		String strStart = String.format("%tF\n", vo.getTimeStart());
		String strEnd = String.format("%tF\n", vo.getTimeEnd());
		
		//String strStart = "2016-08-14";
		//String strEnd = "2016-09-14";

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = df.parse(strStart);
		Date d2 = df.parse(strEnd);

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(d1);
		c2.setTime(d2);
		
		String demo =  "c:\\java\\upload\\temp\\logo.mp4";
		
		FileWriter fiw = new FileWriter(txtName, true);
		fiw.write(demo);
		fiw.flush();
		
		while(c1.compareTo( c2 ) !=1){
			
			String encodingDay = String.format("%tF\n", c1.getTime());
			c1.add(Calendar.DATE, 1);
			
			//txt 내용저장 
			String txt = "file 'c:\\java\\update\\" + vo.getMemberId() + "\\" + vo.getCameraId() + "\\"
					+ "video\\oneday\\" + encodingDay + ".mp4'\r\n";
			
			FileWriter fw = new FileWriter(txtName, true);
			fw.write(txt);
			fw.flush();
			fw.close();
		}
		

		// txt에 등록된 동영상 하나로 모으기
		ProcessBuilder pb = new ProcessBuilder("c:\\ffmpeg\\bin\\ffmpeg.exe", "-f", 
				"concat", "-safe", "0", "-y", "-i", txtName, "-c", "copy", totalFile);
		
		// 프로세스 실행
		pb.redirectErrorStream(true); // 에러출력을 정상출력과 같게

		Process p = pb.start();
		long start = System.currentTimeMillis();

		// 표준출력 상태를 출력
		BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String statusCheck = null;while((statusCheck=stdOut.readLine())!=null)
		{
			System.out.println(statusCheck);
		}

		int i = p.waitFor(); // 0 이면 정상종료

		System.out.println("결과 : "+i+" (0이면 정상종료)");System.out.println("처리 시간 : "+(System.currentTimeMillis()-start)/1000+"초");

		if(0!=i)
		{
			System.out.println("명령 오류 : << " + i + " >>");
			p.destroy();
			return;
		}else
		{
			System.out.println("처리 완료");
			p.destroy();
			return;
		}
	}
}

