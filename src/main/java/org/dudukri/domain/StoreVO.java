package org.dudukri.domain;

public class StoreVO {

	private Integer itemNo; 	 //아이템 번호
	private String memberId;	 //작성자
	private Integer rating; 	//평점
	
	private String itemName; 	//상품명
	private Integer itemPrice;  //가격
	private Integer itemCount;  //재고
	private String itemExplain; //상품설명
	private String itemImgPath; //사진
	
	
	private String itemSummary; //요약?
	private String itemStatus;	 //판매상태?
	
	//필요한가?
	private String timeLapse;	 //타임 랩스 가져오려고
	private Integer orderCount;  //수량계산?
	private String buyer;		 //구매자 id
	private Double lat;		 	 //위도
	private Double lng;			 //경도
	
	private Integer count;
	private double avg;
	
	private Integer timeNo;    //sql문을 위해서

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemExplain() {
		return itemExplain;
	}

	public void setItemExplain(String itemExplain) {
		this.itemExplain = itemExplain;
	}

	public String getItemImgPath() {
		return itemImgPath;
	}

	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
	}

	public String getItemSummary() {
		return itemSummary;
	}

	public void setItemSummary(String itemSummary) {
		this.itemSummary = itemSummary;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getTimeLapse() {
		return timeLapse;
	}

	public void setTimeLapse(String timeLapse) {
		this.timeLapse = timeLapse;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Integer getTimeNo() {
		return timeNo;
	}

	public void setTimeNo(Integer timeNo) {
		this.timeNo = timeNo;
	}

	@Override
	public String toString() {
		return "StoreVO [itemNo=" + itemNo + ", memberId=" + memberId + ",  rating=" + rating
				+ ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCount=" + itemCount + ", itemExplain="
				+ itemExplain + ", itemImgPath=" + itemImgPath + ", itemSummary=" + itemSummary + ", itemStatus="
				+ itemStatus + ", timeLapse=" + timeLapse + ", orderCount=" + orderCount + ", buyer=" + buyer + ", lat="
				+ lat + ", lng=" + lng + ", count=" + count + ", avg=" + avg + ", timeNo=" + timeNo + "]";
	}


	
	
}
