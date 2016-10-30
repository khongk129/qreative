package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.BookmarkVO;
import org.dudukri.domain.FeedbackVO;
import org.dudukri.domain.OrderVO;
import org.dudukri.domain.StoreVO;
import org.dudukri.util.StorePageMaker;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAOImpl implements StoreDAO {

	private final String PATH = "org.dudukri.persistence.StoreMapper";

	@Inject
	private SqlSessionTemplate sqlSession;

	// 포인트 관리 바
	@Override
	public BookmarkVO pointRead(String memberId) {

		return sqlSession.selectOne(PATH + ".pointRead", memberId);
	}

	// 주문 정보
	@Override
	public BookmarkVO deliveryCount(String customerId) {

		return sqlSession.selectOne(PATH + ".deliveryCount", customerId);
	}

	// 즐겨찾기 리스트
	@Override
	public List<BookmarkVO> bookmarkList(StorePageMaker pageMaker) {

		return sqlSession.selectList(PATH + ".bookmarkList", pageMaker);
	}

	// 즐겨찾기 삭제
	@Override
	public void bookmarkDeleted(Integer bookNo) {

		sqlSession.delete(PATH + ".bookmarkDeleted", bookNo);
	}

	// 즐겨찾기 총 갯수
	@Override
	public Integer bookmarkTotalCount(String customerId) {

		return sqlSession.selectOne(PATH + ".bookmarkTotalCount", customerId);
	}

	// 구매 목록 리스트
	@Override
	public List<OrderVO> shoppingList(StorePageMaker pageMaker) {

		return sqlSession.selectList(PATH + ".shoppingList", pageMaker);
	}

	// 즐겨찾기 총 갯수
	@Override
	public Integer shoppingListTotalCount(String customerId) {

		return sqlSession.selectOne(PATH + ".shoppingListTotalCount", customerId);
	}

	// 상품평 등록
	@Override
	public void shoppingFeedbackCreate(FeedbackVO vo) {

		sqlSession.insert(PATH + ".shoppingFeedbackCreate", vo);
	}

	// 상세 정보
	@Override
	public List<StoreVO> itemInfo(Integer itemNo) {
		return sqlSession.selectList(PATH + ".iteminfo", itemNo);
	}

	// 상품평
	@Override
	public List<FeedbackVO> feedbackList(StorePageMaker pagemaker) {
		return sqlSession.selectList(PATH + ".feedbacklist", pagemaker);
	}

	// 댓글 총 갯수
	@Override
	public int feedCount(Integer itemNo) {
		return sqlSession.selectOne(PATH + ".feedcount", itemNo);
	}

	//즐겨찾기 상태
	@Override
	public List<FeedbackVO> bookCheck(FeedbackVO vo) {
		return sqlSession.selectList(PATH + ".bookcheck", vo);
	}

	// 즐겨찾기 추가
	@Override
	public void bookAdd(FeedbackVO vo) {
		sqlSession.insert(PATH + ".bookadd", vo);
	}

	// 즐겨찾기 삭제
	@Override
	public void bookDel(FeedbackVO vo) {
		sqlSession.delete(PATH + ".bookdel", vo);
	}

	@Override
	public void pointCreate(BookmarkVO bookmarkVO) {
		sqlSession.insert(PATH + ".pointCreate", bookmarkVO);
	}

}
