package com.pjt.pjtex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {

	// http://localhost:8090/pjtex/login �� ������

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// @RequestMapping(value = "/login")
	@RequestMapping("/login")
	public String login(Model model) {

		model.addAttribute("loginKey", "eunzzi");

		// login.jsp ����
		return "login";
	}
}
