package org.dudukri.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyItemsBoardVO {

	private int itemNo;
	private String memberId;
	private int timeNo;
	private String itemName;
	private long itemPrice;
	private int itemCount;
	private String itemExplain;
	private List<MultipartFile> itemImgFile;
	private String itemImgPath;
	private List<String> pathList;
	private String itemThumbImgPath;
	private String itemSummary;
	private int itemStatus;
	private String itemCategory;
	private Date regdate;
	private Date modidate;
	private char deleted;
	private List<Integer> listNumber;
	
	private String certNum;
	private String deliNum;
	private String timeImgPath;
	
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public long getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(long itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public String getItemExplain() {
		return itemExplain;
	}
	public void setItemExplain(String itemExplain) {
		this.itemExplain = itemExplain;
	}
	public List<MultipartFile> getItemImgFile() {
		return itemImgFile;
	}
	public void setItemImgFile(List<MultipartFile> itemImgFile) {
		this.itemImgFile = itemImgFile;
	}
	public String getItemImgPath() {
		return itemImgPath;
	}
	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
	}
	public List<String> getPathList() {
		return pathList;
	}
	public void setPathList(List<String> pathList) {
		this.pathList = pathList;
	}
	public String getItemThumbImgPath() {
		return itemThumbImgPath;
	}
	public void setItemThumbImgPath(String itemThumbImgPath) {
		this.itemThumbImgPath = itemThumbImgPath;
	}
	public String getItemSummary() {
		return itemSummary;
	}
	public void setItemSummary(String itemSummary) {
		this.itemSummary = itemSummary;
	}
	public int getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
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
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public List<Integer> getListNumber() {
		return listNumber;
	}
	public void setListNumber(List<Integer> listNumber) {
		this.listNumber = listNumber;
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
	public String getTimeImgPath() {
		return timeImgPath;
	}
	public void setTimeImgPath(String timeImgPath) {
		this.timeImgPath = timeImgPath;
	}
	@Override
	public String toString() {
		return "MyItemsBoardVO [itemNo=" + itemNo + ", memberId=" + memberId + ", timeNo=" + timeNo + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + ", itemCount=" + itemCount + ", itemExplain=" + itemExplain
				+ ", itemImgFile=" + itemImgFile + ", itemImgPath=" + itemImgPath + ", pathList=" + pathList
				+ ", itemThumbImgPath=" + itemThumbImgPath + ", itemSummary=" + itemSummary + ", itemStatus="
				+ itemStatus + ", itemCategory=" + itemCategory + ", regdate=" + regdate + ", modidate=" + modidate
				+ ", deleted=" + deleted + ", listNumber=" + listNumber + ", certNum=" + certNum + ", deliNum="
				+ deliNum + ", timeImgPath=" + timeImgPath + "]";
	}
	
}
