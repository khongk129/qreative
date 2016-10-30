package org.dudukri.controller;

import javax.inject.Inject;

import org.dudukri.domain.LoginDTO;
import org.dudukri.domain.MemberVO;
import org.dudukri.service.MemberService;
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
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public MemberVO loginGET(LoginDTO dto) {

		return service.login(dto);
	}

	// 개인 정보
	@RequestMapping(value = "/information/{memberId}", method = RequestMethod.GET)
	public MemberVO read(@PathVariable String memberId) {

		return service.getRead(memberId);
	}

	// 개인 정보 수정
	@RequestMapping(value = "/information/{memberId}", method = RequestMethod.POST)
	public void update(@RequestBody MemberVO vo) {

		service.setUpdate(vo);
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "/delete/{memberId}", method = RequestMethod.POST)
	public void delete(@RequestBody MemberVO vo) {

		service.setDelete(vo);
	}

	// 아이디체크
	@ResponseBody
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public int IDCheck(@RequestBody String id) {

		return service.IdCheck(id);
	}

	// 회원가입
	@RequestMapping(value = "/insertmember", method = RequestMethod.POST)
	public void insertMember(@RequestBody MemberVO vo) {

		service.InsertMember(vo);
	}

}
