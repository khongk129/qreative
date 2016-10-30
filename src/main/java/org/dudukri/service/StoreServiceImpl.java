package org.dudukri.service;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.BookmarkVO;
import org.dudukri.domain.FeedbackVO;
import org.dudukri.domain.OrderVO;
import org.dudukri.domain.StoreVO;
import org.dudukri.persistence.StoreDAO;
import org.dudukri.util.StorePageMaker;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

	@Inject
	private StoreDAO dao;

	// 포인트 관리 바
	@Override
	public BookmarkVO getPointRead(String customerId) {

		return dao.pointRead(customerId);
	}

	// 주문 정보
	@Override
	public BookmarkVO getDeliveryCount(String customerrId) {

		return dao.deliveryCount(customerrId);
	}

	// 즐겨찾기 리스트
	@Override
	public List<BookmarkVO> getBookmarkList(StorePageMaker pageMaker) {

		return dao.bookmarkList(pageMaker);
	}

	// 즐겨찾기 삭제
	@Override
	public void setBookmarkDeleted(Integer bookNo) {

		dao.bookmarkDeleted(bookNo);
	}

	// 즐겨찾기 총 갯수
	@Override
	public Integer getBookmarkTotalCount(String customerId) {

		return dao.bookmarkTotalCount(customerId);
	}

	// 구매목록 리스트
	@Override
	public List<OrderVO> getShoppingList(StorePageMaker pageMaker) {

		return dao.shoppingList(pageMaker);
	}

	// 구매목록 총갯수
	@Override
	public Integer getShoppingListTotalCount(String customerId) {

		return dao.shoppingListTotalCount(customerId);
	}

	// 상품평 등록
	@Override
	public void setShoppingFeedbackCreate(FeedbackVO vo) {

		dao.shoppingFeedbackCreate(vo);
	}

	// 상품 정보
	@Override
	public List<StoreVO> itemInfo(Integer itemNo) {

		return dao.itemInfo(itemNo);
	}

	// 상품 명
	@Override
	public List<FeedbackVO> feedbackList(StorePageMaker pagemaker) {

		return dao.feedbackList(pagemaker);

	}

	// 댓글  총 갯수
	@Override
	public int feedCount(Integer itemNo) {

		return dao.feedCount(itemNo);
	}

	// 즐겨찾기 상태 확인
	@Override
	public List<FeedbackVO> bookCheck(FeedbackVO vo) {
		return dao.bookCheck(vo);
	}

	// 즐겨찾기 추가
	@Override
	public void bookAdd(FeedbackVO vo) {
		dao.bookAdd(vo);
	}

	// 즐겨찾기 삭제
	@Override
	public void bookDel(FeedbackVO vo) {
		dao.bookDel(vo);
	}

	@Override
	public void setPointCreate(BookmarkVO bookmarkVO) {
		
		BookmarkVO vo = dao.pointRead(bookmarkVO.getCustomerId());
		
		if(vo==null){
			dao.pointCreate(bookmarkVO);
		}else{
			return;
		}
	}
}
