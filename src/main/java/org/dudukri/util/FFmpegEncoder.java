package org.dudukri.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.dudukri.domain.RaspberryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FFmpegEncoder {

	private static final String UPLOAD_DIR = "c:\\java\\upload";
	private static final Logger logger = LoggerFactory.getLogger(FFmpegEncoder.class);
	// 병합 TXT
	// ffmpeg -f concat -safe 0 -i "C:/ffmpeg/conc.txt" -c copy
	// "C:/ffmpeg/test.mp4"

	// 폴더별, 시간별로 들어가서 존재하는 각각의 사진들을 루프돌며
	// 특정 폴더에 xxxx.jpg 형식으로 꺼내서 저장하면 연결 가능!

	// ~ 파일명 시작포인트 어떻게 잡아줄까? 001 아니니까 오류남
	// ~ 동영상 + 동영상 기능 리스트 텍스트 파일로도 되는듯?
	// ~ 쓰레드, 버퍼 비우기
	// ~ 프로세스 끝나면 알려주기(실행시말고)
	// ~ 문제시 로그 찍기
	// ~ 아래 폴더명을 어떻게 가변적으로 하지?

	// public static void main(String[] args) throws Exception{

	public void ffmpegMaker(RaspberryVO vo) throws Exception {
		logger.info("ffmpegMaker Start");
		/*
		 * Calendar cal = new GregorianCalendar(); cal.add(Calendar.DATE, -1);
		 * 
		 * logger.info("어제 년: " + cal.get(Calendar.YEAR));
		 * logger.info("어제 월: " + (cal.get(Calendar.MONTH) + 1));
		 * logger.info("어제 일: " + cal.get(Calendar.DAY_OF_MONTH));
		 */

		//저장경로
		File targetDir = new File(UPLOAD_DIR +"\\"+vo.getMemberId() + "\\data\\" + vo.getRaspID() + "\\img\\" + vo.getYear() + "\\" + vo.getMonth() + "\\" + vo.getDay());
		String todayDate = vo.getYear() + "-" + vo.getMonth() + "-" + vo.getDay();
		
		//시작파일  & 완성파일저장경로
		String inFile = targetDir + "\\%03d.jpg"; // ID/2016/08/03
		String outFile = UPLOAD_DIR + "\\"+vo.getMemberId() + "\\data\\" + vo.getRaspID() + "\\video\\oneday\\"+todayDate+".mp4";

		//디렉토리 생성
		File makeDir = new File(UPLOAD_DIR + "\\"+vo.getMemberId() + "\\data\\" + vo.getRaspID() + "\\video\\");

		if (!makeDir.exists() || !targetDir.isDirectory()) {
			logger.info(makeDir + "Folder Create");
			makeDir.mkdirs();
		}
		
		//인코딩명령어
		ProcessBuilder pb = new ProcessBuilder("c:\\ffmpeg\\bin\\ffmpeg.exe", "-i", inFile, "-y", "-c:v", "libx264",
				"-preset", "veryfast", "-r", "30", "-pix_fmt", "yuv420p", outFile);

		// 프로세스 실행
		pb.redirectErrorStream(true); // 에러출력을 정상출력과 같게
		Process p = pb.start();
		long start = System.currentTimeMillis();

		// 표준출력 상태를 출력 로그
		BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String str = null;
		while ((str = stdOut.readLine()) != null) {
			logger.info(str);
		}

		// 20초가 지나면 종료 되게
		/*
		 * Timer t = new Timer(); t.schedule(new TimerTask(){
		 * 
		 * @Override public void run() { p.destroy(); } }, 20000); t.cancel();
		 */

		int i = p.waitFor(); // 0 이면 정상종료

		if (0 != i) {
			logger.info("명령 오류 : << " + i + " >>");
			p.destroy();
			return;
		} else {
			logger.info("처리 완료");
			p.destroy();
		}
		
		logger.info("결과 : " + i + " (0이면 정상종료)");

		logger.info("처리 시간 : " + (System.currentTimeMillis() - start) / 1000 + "초");

	}

}
