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
	// Service�� �̿����� �ʴ´ٸ� ��ü�� ���� �����ؾ���
	// servlet-context�� autowired ó�� ���ְ� ���
	@Autowired
	MemberService service;

	@RequestMapping(value = "/memJoin", method = RequestMethod.POST)
//	@RequestMapping(value = "/memJoin", method = RequestMethod.GET)
//	@RequestMapping(value = "/memJoin")
//	@RequestMapping("/memJoin")
//	public String memJoin(Model model, HttpServletRequest request) {
//	public String memJoin(Member member) {

	// @ModelAttribute("mem") �����ϸ� view���� mem�� �̸����� ��� ����
	public String memJoin(@ModelAttribute("mem") Member member) {

		// Member.java�� setter�� getter�� �����ϱ� ����
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
	// HttpServletRequest ��� @RequestParam�� ����ص� ��
	// required = true �ݵ�� �Ѿ�;� �Ѵٴ� �Ӽ�
	// defaultValue = "" ���� ���� �Ѿ���� �ʴ´ٸ� �������� ������ �ѱ�ٴ� �Ӽ�
	public String memLogin(Model model, @RequestParam("memId") String memId,
			@RequestParam(value = "memPw", required = true, defaultValue = "1234") String memPw) {

		// HttpServletRequest : ����ڰ� view���� �Է��� �����͸� ���� �ִ� ��ü
		// "memId", "memPw" �� view�� input �±��� name �Ӽ�

		// @RequestParam�� ����ϸ� �� ������ �ʿ����
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