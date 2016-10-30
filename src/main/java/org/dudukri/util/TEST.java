package org.dudukri.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.dudukri.domain.TimeLapseVO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class TEST {
public static void main(String[] args) {
	TEST aa = new TEST();
	aa.qrMaker();
}
	public void qrMaker() {
		
		
		try {
			/*File file = null;
			// 큐알이미지를 저장할 디렉토리 지정   -    미리 만들어놓자 c://zzz//qr//on   &  /off
			String qrFileDir="c:\\zzz\\qr";
			file = new File(qrFileDir);
			if(!file.exists()) {
				file.mkdirs();
			}*/
			
			// 코드인식시 링크걸 URL주소
			String OnCodeUrl = "http://14.32.7.115:607/store/item/455";
			String OnCodeMaker = new String(OnCodeUrl.getBytes("UTF-8"), "ISO-8859-1");
			
			// 큐알코드 바코드 생상값
			int qrcodeColor =   0x2a3740;
			// 큐알코드 배경색상값
			int backgroundColor = 0xFFFFFF;
			
			
			
			//OnCode 생성
			QRCodeWriter OnCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = OnCodeWriter.encode(OnCodeMaker, BarcodeFormat.QR_CODE,200, 200);
			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
			
			//timeImgPath에서 경로 추출
			String qrDirPathStr = "c:\\java\\upload\\";
			String qrImagWriteStr = "c:\\java\\upload\\jebal.png";
			
			File qrDirPath = new File(qrDirPathStr);
			File qrImagWrite = new File(qrImagWriteStr);
			
			if(!qrDirPath.exists()){
				qrDirPath.mkdirs();
			}
			
			ImageIO.write(bufferedImage, "png", qrImagWrite);
		/*	
			timeLapseVO.setQrOnLine(OnCodeUrl);
			timeLapseVO.setQrOnPath("\\"+itemDirPath[1]+"\\"+itemDirPath[2]+"\\"+itemDirPath[3]+"\\qr\\"+itemNo+".png");*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
