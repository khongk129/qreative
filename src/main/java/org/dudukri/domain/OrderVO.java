package org.dudukri.domain;

public class OrderVO {

	private int 	orderNo;			// 주문 번호
	private int 	itemNo;				// 상품 번호
	private String 	memberId;			// 농부 계정
	private String 	customerId;			// 소비자 ID
	private String 	customerPw;			// 소비자 비밀번호
	private String 	customerName;		// 소비자 이름
	private String 	customerZipCode;	// 우편 번호
	private String 	customerAddress1;	// 소비자 주소
	private String 	customerAddress2;	// 소비자 주소 2
	private String 	customerPhone;		// 소비자 전화번호
	private String 	orderStatus;		// 주문 상태
	private int 	orderCount;			// 총 주문 수량
	private int 	totalPrice;			// 총 주문 가격
	
	private String 	itemName;			// 상품 이름
	private String 	itemSummary;		// 상품 요약 설명
	private String 	itemThumbImgPath;	// 상품 작은 이미지
	private char 	deleted;			// 삭제 여부
	
	private int isUser; //user 유무확인
	
	private MyItemsBoardVO item;
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
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
	public String getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerZipCode() {
		return customerZipCode;
	}
	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}
	public String getCustomerAddress1() {
		return customerAddress1;
	}
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}
	public String getCustomerAddress2() {
		return customerAddress2;
	}
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemSummary() {
		return itemSummary;
	}
	public void setItemSummary(String itemSummary) {
		this.itemSummary = itemSummary;
	}
	public String getItemThumbImgPath() {
		return itemThumbImgPath;
	}
	public void setItemThumbImgPath(String itemThumbImgPath) {
		this.itemThumbImgPath = itemThumbImgPath;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public int getIsUser() {
		return isUser;
	}
	public void setIsUser(int isUser) {
		this.isUser = isUser;
	}
	public MyItemsBoardVO getItem() {
		return item;
	}
	public void setItem(MyItemsBoardVO item) {
		this.item = item;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", itemNo=" + itemNo + ", memberId=" + memberId + ", customerId="
				+ customerId + ", customerPw=" + customerPw + ", customerName=" + customerName + ", customerZipCode="
				+ customerZipCode + ", customerAddress1=" + customerAddress1 + ", customerAddress2=" + customerAddress2
				+ ", customerPhone=" + customerPhone + ", orderStatus=" + orderStatus + ", orderCount=" + orderCount
				+ ", totalPrice=" + totalPrice + ", itemName=" + itemName + ", itemSummary=" + itemSummary
				+ ", itemThumbImgPath=" + itemThumbImgPath + ", deleted=" + deleted + ", isUser=" + isUser + ", item="
				+ item + "]";
	}
	
	
}
