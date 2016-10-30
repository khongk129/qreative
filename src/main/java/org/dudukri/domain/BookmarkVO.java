package org.dudukri.domain;

public class BookmarkVO {
	
	private String 	customerId;			// 회원계정
	private String 	customerRole;		// 회원등급
	private String	customerName;		// 회원이름
	private String	customerEmail;		// 회원Email
	private String 	consumer;			// 소비자
	private String	seller;				// 판매자
	private Integer coupon;				// 쿠폰
	private Integer cache;				// 캐쉬
	
	private Integer payCompleted;		// 결제완료
	private Integer deliveryReady;		// 배송준비
	private Integer shipping;			// 배송중
	private Integer deliveryCompleted;	// 배송완료
	
	private Integer bookNo;				// 즐겨찾기 번호
	private Integer itemNo;				// 즐겨찾기한 상품 번호
	private String 	itemImgPath;		// 즐겨찾기한 사진
	private String 	itemName;			// 즐겨찾기한 상품이름
	private Integer itemPrice;			// 즐겨찾기한 상품가격
	private Boolean itemStatus;			// 즐겨찾기한 판매상태
	private char 	deleted;			// 즐겨찾기 삭제
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerRole() {
		return customerRole;
	}
	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Integer getCoupon() {
		return coupon;
	}
	public void setCoupon(Integer coupon) {
		this.coupon = coupon;
	}
	public Integer getCache() {
		return cache;
	}
	public void setCache(Integer cache) {
		this.cache = cache;
	}
	public Integer getPayCompleted() {
		return payCompleted;
	}
	public void setPayCompleted(Integer payCompleted) {
		this.payCompleted = payCompleted;
	}
	public Integer getDeliveryReady() {
		return deliveryReady;
	}
	public void setDeliveryReady(Integer deliveryReady) {
		this.deliveryReady = deliveryReady;
	}
	public Integer getShipping() {
		return shipping;
	}
	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}
	public Integer getDeliveryCompleted() {
		return deliveryCompleted;
	}
	public void setDeliveryCompleted(Integer deliveryCompleted) {
		this.deliveryCompleted = deliveryCompleted;
	}
	public Integer getBookNo() {
		return bookNo;
	}
	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}
	public Integer getItemNo() {
		return itemNo;
	}
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemImgPath() {
		return itemImgPath;
	}
	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
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
	public Boolean getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(Boolean itemStatus) {
		this.itemStatus = itemStatus;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	@Override
	public String toString() {
		return "BookmarkVO [customerId=" + customerId + ", customerRole=" + customerRole + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + ", consumer=" + consumer + ", seller=" + seller
				+ ", coupon=" + coupon + ", cache=" + cache + ", payCompleted=" + payCompleted + ", deliveryReady="
				+ deliveryReady + ", shipping=" + shipping + ", deliveryCompleted=" + deliveryCompleted + ", bookNo="
				+ bookNo + ", itemNo=" + itemNo + ", itemImgPath=" + itemImgPath + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + ", itemStatus=" + itemStatus + ", deleted=" + deleted + "]";
	}
	

}
