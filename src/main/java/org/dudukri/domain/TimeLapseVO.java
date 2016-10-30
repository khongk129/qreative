package org.dudukri.domain;

import java.sql.Timestamp;

public class TimeLapseVO {

	private String memberId;
	private int timeNo;
	private int cameraNo;
	private String cameraNick;
	private String cameraId;
	private int timeCount;
	private String timeVideoPath;
	private String timeImgPath;
	private String timeName;
	private String timeStart;
	private String timeEnd;
	private String qrOnPath;
	private String qrOffPath;
	private String qrOnLine;
	private String qrOffLine;
	private boolean qrStatus;
	private double temp;
	private double humidity;
	private String certNum;
	private String deliNum;
	private Timestamp regDate;
	private Timestamp modiDate;
	private boolean timeStatus;
	private String imgCurTime;
	
	private int itemNo;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getTimeNo() {
		return timeNo;
	}

	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}

	public int getCameraNo() {
		return cameraNo;
	}

	public void setCameraNo(int cameraNo) {
		this.cameraNo = cameraNo;
	}

	public String getCameraNick() {
		return cameraNick;
	}

	public void setCameraNick(String cameraNick) {
		this.cameraNick = cameraNick;
	}

	public String getCameraId() {
		return cameraId;
	}

	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}

	public int getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}

	public String getTimeVideoPath() {
		return timeVideoPath;
	}

	public void setTimeVideoPath(String timeVideoPath) {
		this.timeVideoPath = timeVideoPath;
	}

	public String getTimeImgPath() {
		return timeImgPath;
	}

	public void setTimeImgPath(String timeImgPath) {
		this.timeImgPath = timeImgPath;
	}

	public String getTimeName() {
		return timeName;
	}

	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getQrOnPath() {
		return qrOnPath;
	}

	public void setQrOnPath(String qrOnPath) {
		this.qrOnPath = qrOnPath;
	}

	public String getQrOffPath() {
		return qrOffPath;
	}

	public void setQrOffPath(String qrOffPath) {
		this.qrOffPath = qrOffPath;
	}

	public String getQrOnLine() {
		return qrOnLine;
	}

	public void setQrOnLine(String qrOnLine) {
		this.qrOnLine = qrOnLine;
	}

	public String getQrOffLine() {
		return qrOffLine;
	}

	public void setQrOffLine(String qrOffLine) {
		this.qrOffLine = qrOffLine;
	}

	public boolean isQrStatus() {
		return qrStatus;
	}

	public void setQrStatus(boolean qrStatus) {
		this.qrStatus = qrStatus;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getDeliNum() {
		return deliNum;
	}

	public void setDeliNum(String deliNum) {
		this.deliNum = deliNum;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getModiDate() {
		return modiDate;
	}

	public void setModiDate(Timestamp modiDate) {
		this.modiDate = modiDate;
	}

	public boolean isTimeStatus() {
		return timeStatus;
	}

	public void setTimeStatus(boolean timeStatus) {
		this.timeStatus = timeStatus;
	}

	public String getImgCurTime() {
		return imgCurTime;
	}

	public void setImgCurTime(String imgCurTime) {
		this.imgCurTime = imgCurTime;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	@Override
	public String toString() {
		return "TimeLapseVO [memberId=" + memberId + ", timeNo=" + timeNo + ", cameraNo=" + cameraNo + ", cameraNick="
				+ cameraNick + ", cameraId=" + cameraId + ", timeCount=" + timeCount + ", timeVideoPath="
				+ timeVideoPath + ", timeImgPath=" + timeImgPath + ", timeName=" + timeName + ", timeStart=" + timeStart
				+ ", timeEnd=" + timeEnd + ", qrOnPath=" + qrOnPath + ", qrOffPath=" + qrOffPath + ", qrOnLine="
				+ qrOnLine + ", qrOffLine=" + qrOffLine + ", qrStatus=" + qrStatus + ", temp=" + temp + ", humidity="
				+ humidity + ", certNum=" + certNum + ", deliNum=" + deliNum + ", regDate=" + regDate + ", modiDate="
				+ modiDate + ", timeStatus=" + timeStatus + ", imgCurTime=" + imgCurTime + ", itemNo=" + itemNo + "]";
	}
	
	
}
