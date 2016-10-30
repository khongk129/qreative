package org.dudukri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dudukri.domain.CameraVO;
import org.dudukri.domain.CompanyVO;
import org.dudukri.domain.MemberVO;
import org.dudukri.domain.ReplyVO;
import org.dudukri.domain.SerialVO;
import org.dudukri.service.CompanyService;
import org.dudukri.service.ReplyService;
import org.dudukri.util.CompanyPageMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/company/")
public class CompanyController {

	@Inject
	private CompanyService service;

	@Inject
	private ReplyService replyService;

	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@RequestMapping(value = "/member/{page}", method = RequestMethod.GET)
	public Map<String, Object> memberList(@PathVariable("page") Integer curPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		CompanyPageMaker pageMaker = new CompanyPageMaker();

		pageMaker.setCurPage(curPage);
		pageMaker.setTotalMember(service.totalMember());

		List<MemberVO> list = service.memberList(pageMaker);

		logger.info("" + list.toString());

		map.put("list", list);
		map.put("pageMaker", pageMaker);

		return map;
	}

	@RequestMapping(value = "/camera/{page}", method = RequestMethod.GET)
	public Map<String, Object> cameraList(@PathVariable("page") Integer curPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		CompanyPageMaker pageMaker = new CompanyPageMaker();

		pageMaker.setCurPage(curPage);
		pageMaker.setTotalMember(service.totalCamera());

		List<CameraVO> list = service.cameraList(pageMaker);

		logger.info("" + list.toString());

		map.put("list", list);
		map.put("pageMaker", pageMaker);

		return map;
	}

	@RequestMapping(value = "/serial/{page}", method = RequestMethod.GET)
	public Map<String, Object> serialList(@PathVariable("page") Integer curPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		CompanyPageMaker pageMaker = new CompanyPageMaker();

		pageMaker.setCurPage(curPage);
		pageMaker.setTotalMember(service.totalSerial());

		List<SerialVO> list = service.serialList(pageMaker);

		logger.info("" + list.toString());

		map.put("list", list);
		map.put("pageMaker", pageMaker);

		return map;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public Map<String, Object> mainList() {

		Map<String, Object> map = new HashMap<String, Object>();

		CompanyVO vo = new CompanyVO();

		vo.setTotalMember(service.totalMember());
		vo.setTotalRecentMember(service.totalRecentMember());
		vo.setTotalQuitMember(service.totalQuitMember());
		vo.setTotalRecentCamera(service.totalRecentCamera());
		vo.setTotalDisabledCamera(service.totalDisabledCamera());
		vo.setTotalNotyetAnsweredQna(service.totalNotyetAnsweredQna());

		List<CompanyVO> memberlist = service.mainMemberList();
		List<CompanyVO> cameralist = service.mainCameraList();
		List<CompanyVO> qnalist = service.mainQnaList();

		map.put("memberList", memberlist);
		map.put("qnaList", qnalist);
		map.put("cameraList", cameralist);

		map.put("countList", vo);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/quitmember", method = RequestMethod.POST)
	public void quitMember(@RequestBody String[] memberId) {

		for (int i = 0; i < memberId.length; i++) {

			logger.info("memberId = " + memberId[i]);

			service.quitMember(memberId[i]);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/promotemember", method = RequestMethod.POST)
	public void promoteMember(@RequestBody String[] memberId) {

		for (int i = 0; i < memberId.length; i++) {

			logger.info("memberId = " + memberId[i]);

			service.promoteMember(memberId[i]);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/demotemember", method = RequestMethod.POST)
	public void demoteMember(@RequestBody String[] memberId) {

		for (int i = 0; i < memberId.length; i++) {

			logger.info("memberId = " + memberId[i]);

			service.demoteMember(memberId[i]);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/deleteserial", method = RequestMethod.POST)
	public void deleteSerial(@RequestBody String[] cameraId) {

		for (int i = 0; i < cameraId.length; i++) {

			logger.info("cameraId = " + cameraId[i]);

			service.deleteSerial(cameraId[i]);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/inputserial", method = RequestMethod.POST)
	public void inputSerial(@RequestBody String cameraId) {

		String temp = cameraId;

		temp = temp.replaceAll("\"", "");

		logger.info("sssaaacameraId = " + cameraId);

		service.inputSerial(temp);

	}

	@RequestMapping(value = "/needhelp/{page}", method = RequestMethod.GET)
	public Map<String, Object> needHelpList(@PathVariable("page") Integer curPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		CompanyPageMaker pageMaker = new CompanyPageMaker();

		pageMaker.setCurPage(curPage);
		pageMaker.setTotalMember(service.totalNeedHelp());

		List<CompanyVO> list = service.needHelpList(pageMaker);

		map.put("list", list);
		map.put("pageMaker", pageMaker);

		return map;
	}

	@RequestMapping(value = "/needhelp/view/{qnaNo}", method = RequestMethod.GET)
	public Map<String, Object> needHelpView(@PathVariable("qnaNo") Integer qnaNo) {

		Map<String, Object> map = new HashMap<String, Object>();
		CompanyPageMaker pageMaker = new CompanyPageMaker();

		logger.info("qnoNumber: " + qnaNo);

		CompanyVO view = service.needHelpView(qnaNo);
		ReplyVO reply = replyService.getReplyRead(qnaNo);
		map.put("view", view);
		if (reply == null) {
			map.put("view", view);
		} else {
			map.put("reply", reply);
			map.put("view", view);
		}
		return map;
	}

	// 답변 등록
	@ResponseBody
	@RequestMapping(value = "/needhelp/create", method = RequestMethod.POST)
	public void needHelpCreate(@RequestBody ReplyVO vo) {
		logger.info("vo 는" + vo);
		replyService.needHelpCreate(vo);
		service.qnaStatus(vo);
	}

	// 답변 변경
	@ResponseBody
	@RequestMapping(value = "/needhelp/update", method = RequestMethod.POST)
	public void needHelpUpdate(@RequestBody ReplyVO vo) {
		logger.info("vo 는" + vo);
		replyService.needHelpUpdate(vo);
	}

}
