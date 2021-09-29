package com.bs.lec21.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bs.lec21.member.Member;
import com.bs.lec21.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		return dateFormat.format(date);
	}

	// Join
	@RequestMapping("/joinForm")
	public String joinForm(Member member) {
		return "/member/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(Member member) {

		service.memberRegister(member);

		return "/member/joinOk";
	}

	// Login
	@RequestMapping("/loginForm")
	public String loginForm(Member member) {
		return "/member/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memLogin(Member member, HttpSession session) {

		Member mem = service.memberSearch(member);

		session.setAttribute("member", mem);

		return "/member/loginOk";
	}

	// Logout
	@RequestMapping("/logout")
	public String memLogout(Member member, HttpSession session) {

		session.invalidate();

		return "/member/logoutOk";
	}

	// Modify
	@RequestMapping(value = "/modifyForm")
	public String modifyForm(Model model, HttpServletRequest request) {

		// 현재 로그인 되어있는 회원의 정보를 가져옴
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		// 로그인이 되어있지 않다면
		if (null == member) {
			// 메인 경로로
			return "redirect:/";
		}
		// 로그인이 되어있다면
		else {
			model.addAttribute("member", service.memberSearch(member));
		}

		return "/member/modifyForm";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(Member member, HttpServletRequest request) {

		HttpSession session = request.getSession();

		Member mem = service.memberModify(member);
		session.setAttribute("member", mem);

		ModelAndView mav = new ModelAndView();
		mav.addObject("memAft", mem);
		mav.setViewName("/member/modifyOk");

		return mav;
	}

	// Remove
	@RequestMapping("/removeForm")
	public ModelAndView removeForm(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		// 현재 로그인 되어있는 회원의 정보를 가져옴
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		// 반환값이 ModelAndView 때문에 setViewName 사용
		if (null == member) {
			mav.setViewName("redirect:/");
		} else {
			mav.addObject("member", member);
			mav.setViewName("/member/removeForm");
		}

		return mav;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String memRemove(Member member, HttpServletRequest request) {

		service.memberRemove(member);

		HttpSession session = request.getSession();
		session.invalidate();

		return "/member/removeOk";
	}

}