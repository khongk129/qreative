package org.dudukri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.dudukri.domain.CameraAndTimelapseInfoVO;
import org.dudukri.domain.MyItemsBoardVO;
import org.dudukri.domain.TimeLapseVO;
import org.dudukri.util.PageMaker;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyItemsBoardDAOImpl implements MyItemsBoardDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertItems(MyItemsBoardVO myItemsBoardVO) {
		
		sqlSession.insert("MyItemsMapper.insertItems", myItemsBoardVO);

	}

	@Override
	public List<MyItemsBoardVO> listItems(PageMaker pageMaker) {
		
		return sqlSession.selectList("MyItemsMapper.listItems", pageMaker);
	}

	@Override
	public MyItemsBoardVO viewItems(MyItemsBoardVO myItemsBoardVO) {

		return sqlSession.selectOne("MyItemsMapper.viewItems", myItemsBoardVO);
	}

	@Override
	public int count(String memberId) {
		return sqlSession.selectOne("MyItemsMapper.count", memberId);
	}

	@Override
	public void deleteItems(List<String> itemNo) {
		sqlSession.update("MyItemsMapper.deleteItems", itemNo);
	}

	@Override
	public void updateItems(MyItemsBoardVO myItemsBoardVO) {
		sqlSession.update("MyItemsMapper.updateItems", myItemsBoardVO);
		
	}

	@Override
	public TimeLapseVO timelapsData(TimeLapseVO timeLapseVO) {
		
		return sqlSession.selectOne("MyItemsMapper.timelapsData", timeLapseVO);
	}

	@Override
	public List<CameraAndTimelapseInfoVO> getCameraNick(String memberId) {
		return sqlSession.selectList("MyItemsMapper.getCameraNick", memberId);
	}

	@Override
	public List<CameraAndTimelapseInfoVO> getTimelapseInfo(PageMaker pagemaker) {
		return sqlSession.selectList("MyItemsMapper.getTimelapseInfo", pagemaker);
	}

	@Override
	public int timelapseCount(PageMaker pagemaker) {
		return sqlSession.selectOne("MyItemsMapper.timelapseCount", pagemaker);
	}

	@Override
	public List<MyItemsBoardVO> itemBytimeNo(MyItemsBoardVO myItemsBoardVO) {
		return sqlSession.selectList("MyItemsMapper.itemBytimeNo", myItemsBoardVO);
	}



}
