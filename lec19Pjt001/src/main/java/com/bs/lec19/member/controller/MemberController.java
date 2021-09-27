package com.bs.lec19.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bs.lec19.member.Member;
import com.bs.lec19.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;

	@ModelAttribute("serverTime")
	// �޼ҵ� ȣ�� �� ���� �ð� view���� ���
	// �׻� ���� ��µ�
	public String getServerTime(Locale locale) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		return dateFormat.format(date);
	}

	@RequestMapping(value = "/memJoin", method = RequestMethod.POST)
	public String memJoin(Member member) {

		service.memberRegister(member);

		return "memJoinOk";
	}

	@RequestMapping(value = "/memLogin", method = RequestMethod.POST)
	public String memLogin(Member member) {

		service.memberSearch(member);

		return "memLoginOk";
	}

	@RequestMapping(value = "/memRemove", method = RequestMethod.POST)
	public String memRemove(@ModelAttribute("mem") Member member) {

		service.memberRemove(member);

		return "memRemoveOk";
	}

	// Model : view�� �����͸��� �����ϱ� ���� ��ü
	// ModelAndView : �����Ϳ� view ������ �̸��� �Բ� �����ϴ� ��ü

	/*
	 * @RequestMapping(value = "/memModify", method = RequestMethod.POST) public
	 * String memModify(Model model, Member member) {
	 * 
	 * Member[] members = service.memberModify(member);
	 * 
	 * model.addAttribute("memBef", members[0]); model.addAttribute("memAft",
	 * members[1]);
	 * 
	 * return "memModifyOk"; }
	 */
	
	@RequestMapping(value = "/memModify", method = RequestMethod.POST)
	public ModelAndView memModify(Member member) {

		Member[] members = service.memberModify(member);

		// ModelAndView ��ü ����
		ModelAndView mav = new ModelAndView();
		
		// ��ü�� addObject�� Ȱ���� ������ �߰�
		mav.addObject("memBef", members[0]);
		mav.addObject("memAft", members[1]);

		// view �̸��� �߰�
		mav.setViewName("memModifyOk");

		// ModelAndView ��ü ��ü�� �����������
		return mav;
	}

}
