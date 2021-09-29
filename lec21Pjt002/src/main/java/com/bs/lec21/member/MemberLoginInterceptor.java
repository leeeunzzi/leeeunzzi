package com.bs.lec21.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HandlerInterceptorAdapter 상속
public class MemberLoginInterceptor extends HandlerInterceptorAdapter {

	// 컨트롤러가 작동하기 전단계에 먼저 작업
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 세션 가져오기
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 오브젝트 가져오기
			Object obj = session.getAttribute("member");
			if (obj != null)
				return true;
		}

		// 세션이 없다면 메인페이지로 이동 (sendRedirect 사용)
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}

	// 컨트롤러가 작동된 후에 작업
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	// 컨트롤러와 뷰가 다 작업된 후에 작업
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}
}