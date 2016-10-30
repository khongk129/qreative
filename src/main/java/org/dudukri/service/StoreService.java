package org.dudukri.service;

import java.util.List;

import org.dudukri.domain.BookmarkVO;
import org.dudukri.domain.FeedbackVO;
import org.dudukri.domain.OrderVO;
import org.dudukri.domain.StoreVO;
import org.dudukri.util.StorePageMaker;

public interface StoreService {
	
	// 소비자 즐겨찾기
	public BookmarkVO getPointRead				(String customerId);			// 포인트 관리 바
	public void setPointCreate					(BookmarkVO bookmarkVO);	// 포인트 등록
	public BookmarkVO getDeliveryCount			(String customerId);			// 주문정보
	public List<BookmarkVO> getBookmarkList		(StorePageMaker pageMaker);	// 즐겨찾기 리스트
	public void setBookmarkDeleted				(Integer bookNo);			// 즐겨찾기 삭제
	public Integer getBookmarkTotalCount		(String customerId);			// 즐겨찾기 총 갯수
	
	// 소비자 구매목록 페이지
	public List<OrderVO> getShoppingList		(StorePageMaker pageMaker);	// 주문 완료 목록
	public Integer getShoppingListTotalCount	(String customerId);			// 구매 목록 총 갯수
	public void setShoppingFeedbackCreate 		(FeedbackVO vo);			// 상품평 등록

	// 상세 페이지
	public List<StoreVO> itemInfo 				(Integer itemNo);			// 상세 정보
	public List<FeedbackVO> feedbackList 		(StorePageMaker pagemaker);	// 상품평
	public List<FeedbackVO> bookCheck 			(FeedbackVO vo);  			// 즐겨찾기 상태 확인
	public void bookAdd 						(FeedbackVO vo);			// 즐겨찾기 추가
	public void bookDel 						(FeedbackVO vo);			// 즐겨찾기 삭제
	public int feedCount 						(Integer itemNo);			// 댓글 총 갯수
}
