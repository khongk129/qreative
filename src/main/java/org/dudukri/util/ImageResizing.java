package org.dudukri.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.dudukri.domain.MyItemsBoardVO;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class ImageResizing {

	private static Logger logger = LoggerFactory.getLogger(ImageResizing.class);
	
	public void imageResizing(MyItemsBoardVO myItemsBoardVO){

		String [] itemDirPath = myItemsBoardVO.getTimeImgPath().split("\\\\");

		String thumbFilePath = "C:\\java\\upload\\"+itemDirPath[1]+"\\"+itemDirPath[2]+"\\"+itemDirPath[3]+"\\itemImg\\s_"+myItemsBoardVO.getItemNo();

		File imgDirPath = new File(thumbFilePath);

		if(!imgDirPath.exists()){
			imgDirPath.mkdirs();
		}

		
		
		List<MultipartFile> itemImgFileList = myItemsBoardVO.getItemImgFile();

		for(int i=0; i<itemImgFileList.size(); i++){
			
			logger.info("imgName(ImageResizing): "+itemImgFileList.get(i).getOriginalFilename());
			
			try {

				BufferedImage buff=ImageIO.read(itemImgFileList.get(i).getInputStream());

				BufferedImage thumb = Scalr.resize(buff, 
						Scalr.Method.AUTOMATIC,
						Scalr.Mode.FIT_TO_HEIGHT,200);

				FileOutputStream sFos = new FileOutputStream(thumbFilePath+"\\"+itemImgFileList.get(i).getOriginalFilename());

				ImageIO.write(thumb, "JPG", sFos);
				
				sFos.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}//end for
		
		//썸네일패스에 경로 담기
		myItemsBoardVO.setItemThumbImgPath("\\"+itemDirPath[1]+"\\"+itemDirPath[2]+"\\"+itemDirPath[3]+"\\itemImg\\s_"+myItemsBoardVO.getItemNo());

	}
}
