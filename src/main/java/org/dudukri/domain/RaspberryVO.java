package org.dudukri.domain;

import org.springframework.web.multipart.MultipartFile;

public class RaspberryVO {

	private MultipartFile file;
	private float temperature;
	private float humidity;
	private String raspID, year, month, day, hour, minute;
	private String origiFilename;
	private String memberId;
	
	
	public MultipartFile getMultipartFile() {
		return file;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.file = multipartFile;
		
		// 파일명 잘라서 배열에 넣어줌
		String[] temp = file.getOriginalFilename().split("_");
		
		this.origiFilename = file.getOriginalFilename();
		this.raspID=temp[0];
		this.year=temp[1];
		this.month=temp[2];
		this.day=temp[3];
		this.hour=temp[4];
		this.minute=temp[5];
		
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public String getRaspID() {
		return raspID;
	}
	public void setRaspID(String raspID) {
		this.raspID = raspID;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getOrigiFilename() {
		return origiFilename;
	}
	public void setOrigiFilename(String origiFilename) {
		this.origiFilename = origiFilename;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "RaspberryVO [file=" + file + ", temperature=" + temperature + ", humidity=" + humidity + ", raspID="
				+ raspID + ", year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour + ", minute="
				+ minute + ", origiFilename=" + origiFilename + ", memberId=" + memberId + "]";
	}
	
}
