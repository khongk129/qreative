package org.dudukri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.QnAVO;
import org.dudukri.domain.ReplyVO;
import org.dudukri.service.QnAService;
import org.dudukri.service.ReplyService;
import org.dudukri.util.QnAPageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/qna")
public class QnAController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	
	@Inject
	private QnAService service; // QnA
	
	@Inject
	private ReplyService replyService; // 댓글
	
	
	// 질문 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void create(@RequestBody QnAVO vo){
		
		service.setCreate(vo);
	}
	
	// 질문 리스트
	@RequestMapping(value = "/list/{memberId}/{page}/{perListNum}", method = RequestMethod.GET)
	public Map<String, Object> read(@PathVariable("memberId") String memberId, @PathVariable("page") Integer page, @PathVariable("perListNum") Integer perListNum){
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		QnAPageMaker pageMaker = new QnAPageMaker();
		int totalCount = service.getTotalCount(memberId);
		
		pageMaker.setMemberId	(memberId);
		pageMaker.setPage		(page);
		pageMaker.setPerListNum	(perListNum);
		pageMaker.setTotalCount	(totalCount);
		
		List<QnAVO> list = service.getRead(pageMaker);
		
		map.put("list", list);				// 질문 리스트
		map.put("pageMaker", pageMaker);	// 페이징
		
		return map;
	}
	
	// 작성된 화면
	@RequestMapping(value = "/view/{qnaNo}", method = RequestMethod.GET)
	public Map<String, Object> view(@PathVariable int qnaNo){
		
		logger.info("qnoNumber: "+qnaNo);
		
		Map<String, Object> map = new HashMap<>();
		
		QnAVO view = service.getView(qnaNo);
		ReplyVO reply = replyService.getReplyRead(qnaNo);
		
		if(reply == null){
			map.put("view", view);
		}else{
			map.put("reply", reply);
			map.put("view", view);
		}
		
		return map;
	}
	
	// 질문 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody QnAVO vo){
		
		service.setUpdate(vo);
	}
	
	// 질문 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody Integer qnaNo){
		
		service.setDelete(qnaNo);
	}

}
