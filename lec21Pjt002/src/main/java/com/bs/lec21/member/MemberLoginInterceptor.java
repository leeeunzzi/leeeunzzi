package com.bs.lec21.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HandlerInterceptorAdapter ���
public class MemberLoginInterceptor extends HandlerInterceptorAdapter {

	// ��Ʈ�ѷ��� �۵��ϱ� ���ܰ迡 ���� �۾�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// ���� ��������
		HttpSession session = request.getSession(false);
		if (session != null) {
			// ������Ʈ ��������
			Object obj = session.getAttribute("member");
			if (obj != null)
				return true;
		}

		// ������ ���ٸ� ������������ �̵� (sendRedirect ���)
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}

	// ��Ʈ�ѷ��� �۵��� �Ŀ� �۾�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	// ��Ʈ�ѷ��� �䰡 �� �۾��� �Ŀ� �۾�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}
}