package org.dudukri.domain;

import java.sql.Date;

public class SerialVO {

	String 	cameraId;
	String 	serialStatus;
	Date	regDate;
	Date	insDate;
	char 	deleted;
	
	public String getCameraId() {
		return cameraId;
	}
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	public String getSerialStatus() {
		return serialStatus;
	}
	public void setSerialStatus(String serialStatus) {
		this.serialStatus = serialStatus;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "SerialVO [cameraId=" + cameraId + ", regDate=" + regDate + ", insDate=" + insDate + ", serialStatus="
				+ serialStatus + ", deleted=" + deleted + "]";
	}
	
	
	
}
