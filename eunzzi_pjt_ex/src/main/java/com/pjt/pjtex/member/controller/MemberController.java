package com.pjt.pjtex.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjt.pjtex.member.Member;
import com.pjt.pjtex.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

//	MemberService service = new MemberService();
//	@Resource(name="memService")
	// Service를 이용하지 않는다면 객체를 새로 생성해야함
	// servlet-context에 autowired 처리 해주고 사용
	@Autowired
	MemberService service;

	@RequestMapping(value = "/memJoin", method = RequestMethod.POST)
//	@RequestMapping(value = "/memJoin", method = RequestMethod.GET)
//	@RequestMapping(value = "/memJoin")
//	@RequestMapping("/memJoin")
//	public String memJoin(Model model, HttpServletRequest request) {
//	public String memJoin(Member member) {

	// @ModelAttribute("mem") 설정하면 view에서 mem의 이름으로 사용 가능
	public String memJoin(@ModelAttribute("mem") Member member) {

		// Member.java의 setter와 getter가 존재하기 때문
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
//		String memMail = request.getParameter("memMail");
//		String memPhone1 = request.getParameter("memPhone1");
//		String memPhone2 = request.getParameter("memPhone2");
//		String memPhone3 = request.getParameter("memPhone3");

//		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		service.memberRegister(member.getMemId(), member.getMemPw(), member.getMemMail(), member.getMemPhone1(),
				member.getMemPhone2(), member.getMemPhone3());

//		model.addAttribute("memId", memId);
//		model.addAttribute("memPw", memPw);
//		model.addAttribute("memMail", memMail);
//		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);

		return "memJoinOk";
	}

	@RequestMapping(value = "/memLogin", method = RequestMethod.POST)
	/* public String memLogin(Model model, HttpServletRequest request) { */
	// HttpServletRequest 대신 @RequestParam을 사용해도 됨
	// required = true 반드시 넘어와야 한다는 속성
	// defaultValue = "" 만약 값이 넘어오지 않는다면 지정해준 값으로 넘긴다는 속성
	public String memLogin(Model model, @RequestParam("memId") String memId,
			@RequestParam(value = "memPw", required = true, defaultValue = "1234") String memPw) {

		// HttpServletRequest : 사용자가 view에서 입력한 데이터를 갖고 있는 객체
		// "memId", "memPw" 는 view의 input 태그의 name 속성

		// @RequestParam을 사용하면 이 절차가 필요없음
		// String memId = request.getParameter("memId");
		// String memPw = request.getParameter("memPw");

		Member member = service.memberSearch(memId, memPw);

		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "memLoginOk";
	}

}