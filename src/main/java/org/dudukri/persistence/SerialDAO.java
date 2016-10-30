package org.dudukri.persistence;

import org.dudukri.domain.SerialVO;

public interface SerialDAO {

	public Boolean serialidRead(String cameraId);
	
	public SerialVO read();
}
