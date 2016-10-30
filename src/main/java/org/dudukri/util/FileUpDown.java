package org.dudukri.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.dudukri.domain.MyItemsBoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUpDown {

	private static Logger logger = LoggerFactory.getLogger(FileUpDown.class);

	public void downLoadToDB(MyItemsBoardVO myItemsBoardVO) {

		logger.info("FileUpDown downLoadToDB Start..........");

		logger.info("timeImgPath!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: "+myItemsBoardVO.getTimeImgPath());
		
		String [] itemDirPath = myItemsBoardVO.getTimeImgPath().split("\\\\");

		String imgDirPathStr = "c:\\java\\upload\\"+itemDirPath[1]+"\\"+itemDirPath[2]+"\\"+itemDirPath[3]+"\\itemImg\\"+myItemsBoardVO.getItemNo();

		File imgDirPath = new File(imgDirPathStr);

		if(!imgDirPath.exists()){
			imgDirPath.mkdirs();
		}

		String fileLocation = "\\"+itemDirPath[1]+"\\"+itemDirPath[2]+"\\"+itemDirPath[3]+"\\itemImg\\"+myItemsBoardVO.getItemNo();

		myItemsBoardVO.setItemImgPath(fileLocation);


		List<MultipartFile> itemImgFileList = myItemsBoardVO.getItemImgFile();

		for(int i=0; i<itemImgFileList.size(); i++){
			
			logger.info("imgName(FileUpDown): "+itemImgFileList.get(i).getOriginalFilename());

			try {
				FileOutputStream fos = new FileOutputStream(imgDirPathStr+"\\"+itemImgFileList.get(i).getOriginalFilename());
				
				IOUtils.copy(itemImgFileList.get(i).getInputStream(), fos);
				
				fos.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}//end for
		
	}

}
