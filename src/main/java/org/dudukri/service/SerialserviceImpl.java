package org.dudukri.service;

import javax.inject.Inject;

import org.dudukri.domain.SerialVO;
import org.dudukri.persistence.SerialDAO;
import org.springframework.stereotype.Service;

@Service
public class SerialserviceImpl implements SerialService {

	@Inject
	SerialDAO dao;
	
	@Override
	public boolean serialidRead(String cameraId) {
		
		return dao.serialidRead(cameraId);
	}
}
