package org.dudukri.persistence;

import java.util.List;

import org.dudukri.domain.BookmarkVO;
import org.dudukri.domain.FeedbackVO;
import org.dudukri.domain.OrderVO;
import org.dudukri.domain.StoreVO;
import org.dudukri.util.StorePageMaker;

public interface StoreDAO {
	
	// 소비자 즐겨찾기 
	public BookmarkVO pointRead				(String customerId); 			// 포인트 관리 바
	public void pointCreate					(BookmarkVO bookmarkVO);	// 포인트 등록
	public BookmarkVO deliveryCount			(String customerId);			// 주문 정보
	public List<BookmarkVO> bookmarkList	(StorePageMaker pageMaker); // 즐겨찾기 리스트
	public void bookmarkDeleted				(Integer bookNo);			// 즐겨찾기 삭제 
	public Integer bookmarkTotalCount		(String customerId);			// 즐겨찾기 총 갯수
	
	// 소비자 구매목록 페이지
	public List<OrderVO> shoppingList		(StorePageMaker pageMaker);	// 구입 완료 목록
	public Integer shoppingListTotalCount	(String customerId);			// 구매 목록 총 갯수
	public void shoppingFeedbackCreate		(FeedbackVO vo);			// 상품평 등록

	// 상세 페이지
	public List<StoreVO> itemInfo 			(Integer itemNo);			// 상세 정보
	public List<FeedbackVO> feedbackList 	(StorePageMaker pagemaker); // 상품평
	public List<FeedbackVO> bookCheck 		(FeedbackVO vo);  			// 즐겨찾기 상태 확인
	public void bookAdd 					(FeedbackVO vo); 			// 즐겨찾기 추가
	public void bookDel 					(FeedbackVO vo); 			// 즐겨찾기 삭제
	public int feedCount 					(Integer itemNo); 			// 댓글 총 갯수
	
	
}
