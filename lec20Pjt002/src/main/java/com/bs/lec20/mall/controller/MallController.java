package com.bs.lec20.mall.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.lec20.mall.Mall;

@Controller
@RequestMapping("/mall")
public class MallController {

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

	// 생성된 Cookie를 가져올 땐 @CookieValue를 써야함
	// value 속성은 쿠키 이름
	@RequestMapping("/index")
	public String mallIndex(Mall mall, @CookieValue(value = "gender", required = false) Cookie genderCookie,
			HttpServletRequest request) {

		// 쿠키가 존재한다면
		if (genderCookie != null)
			// 값 지정
			mall.setGender(genderCookie.getValue());

		return "/mall/index";
	}

	@RequestMapping("/main")
	public String mallMain(Mall mall, HttpServletResponse response) {

		Cookie genderCookie = new Cookie("gender", mall.getGender());

		if (mall.isCookieDel()) {
			genderCookie.setMaxAge(0);
			mall.setGender(null);
		} else {
			genderCookie.setMaxAge(60 * 60 * 24 * 30);
		}
		response.addCookie(genderCookie);

		return "/mall/main";
	}

}