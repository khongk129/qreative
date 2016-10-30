package org.dudukri.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PathToPathList {

	public List<String> pathList(String path){

		List<String> pathList = new ArrayList<>();
		
		String dirFullPath = "c:\\java\\upload"+path;
		
		File fileFullPath = new File(dirFullPath);
		
		File[] flist = fileFullPath.listFiles();
		
		for (int i = 0; i < flist.length; i++) {
			
			String fileName = flist[i].getName();
			
			String filePath = path +"\\"+fileName; //--> //memberId//serialNumber//data....형식
			
			pathList.add(filePath);
		}
			
		return pathList;
	}
}
