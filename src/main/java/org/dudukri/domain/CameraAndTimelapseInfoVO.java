package org.dudukri.domain;

public class CameraAndTimelapseInfoVO {

	private int cameraNo;
	private int timeNo;
	private String memberId;
	private String cameraNick;
	private String timeName;
	private String timeImgPath;
	private String timeVideoPath;
	private String timeStart;
	private String timeEnd;
	private int timeStatus;
	private String qrOnline;
	private String qrOnPath;
	private int qrStatus;
	public int getCameraNo() {
		return cameraNo;
	}
	public void setCameraNo(int cameraNo) {
		this.cameraNo = cameraNo;
	}
	public int getTimeNo() {
		return timeNo;
	}
	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCameraNick() {
		return cameraNick;
	}
	public void setCameraNick(String cameraNick) {
		this.cameraNick = cameraNick;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public String getTimeImgPath() {
		return timeImgPath;
	}
	public void setTimeImgPath(String timeImgPath) {
		this.timeImgPath = timeImgPath;
	}
	public String getTimeVideoPath() {
		return timeVideoPath;
	}
	public void setTimeVideoPath(String timeVideoPath) {
		this.timeVideoPath = timeVideoPath;
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
	public int getTimeStatus() {
		return timeStatus;
	}
	public void setTimeStatus(int timeStatus) {
		this.timeStatus = timeStatus;
	}
	public String getQrOnline() {
		return qrOnline;
	}
	public void setQrOnline(String qrOnline) {
		this.qrOnline = qrOnline;
	}
	public String getQrOnPath() {
		return qrOnPath;
	}
	public void setQrOnPath(String qrOnPath) {
		this.qrOnPath = qrOnPath;
	}
	public int getQrStatus() {
		return qrStatus;
	}
	public void setQrStatus(int qrStatus) {
		this.qrStatus = qrStatus;
	}
	@Override
	public String toString() {
		return "CameraAndTimelapseInfoVO [cameraNo=" + cameraNo + ", timeNo=" + timeNo + ", memberId=" + memberId
				+ ", cameraNick=" + cameraNick + ", timeName=" + timeName + ", timeImgPath=" + timeImgPath
				+ ", timeVideoPath=" + timeVideoPath + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", timeStatus=" + timeStatus + ", qrOnline=" + qrOnline + ", qrOnPath=" + qrOnPath + ", qrStatus="
				+ qrStatus + "]";
	}
	
}
