package org.dudukri.domain;

import java.sql.Date;

public class CameraVO {
	
	String 	memberId;
	int 	cameraNo;
	String 	cameraId;
	String 	cameraNick;
	Date   	cameraInsDate;
	String 	cameraStatus;
	int		cameraTimer;
	boolean	cameraSwitch;
	Date	regdate;
	Date	modidate;
	boolean deleted;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getCameraNo() {
		return cameraNo;
	}
	public void setCameraNo(int cameraNo) {
		this.cameraNo = cameraNo;
	}
	public String getCameraId() {
		return cameraId;
	}
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	public String getCameraNick() {
		return cameraNick;
	}
	public void setCameraNick(String cameraNick) {
		this.cameraNick = cameraNick;
	}
	public Date getCameraInsDate() {
		return cameraInsDate;
	}
	public void setCameraInsDate(Date cameraInsDate) {
		this.cameraInsDate = cameraInsDate;
	}
	public String getCameraStatus() {
		return cameraStatus;
	}
	public void setCameraStatus(String cameraStatus) {
		this.cameraStatus = cameraStatus;
	}
	public int getCameraTimer() {
		return cameraTimer;
	}
	public void setCameraTimer(int cameraTimer) {
		this.cameraTimer = cameraTimer;
	}
	public boolean isCameraSwitch() {
		return cameraSwitch;
	}
	public void setCameraSwitch(boolean cameraSwitch) {
		this.cameraSwitch = cameraSwitch;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		return "CameraVO [memberId=" + memberId + ", cameraNo=" + cameraNo + ", cameraId=" + cameraId + ", cameraNick="
				+ cameraNick + ", cameraInsDate=" + cameraInsDate + ", cameraStatus=" + cameraStatus + ", cameraTimer="
				+ cameraTimer + ", cameraSwitch=" + cameraSwitch + ", regdate=" + regdate + ", modidate=" + modidate
				+ ", deleted=" + deleted + "]";
	}
}
	