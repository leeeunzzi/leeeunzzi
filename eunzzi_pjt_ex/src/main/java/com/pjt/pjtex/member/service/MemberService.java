package com.pjt.pjtex.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.pjtex.member.Member;
import com.pjt.pjtex.member.dao.MemberDao;

// servlet-context에 자동 주입 설정 처리하지 않고
// @Service 써주면 자동적으로 스프링 컨테이너에 담김
// @Service
// @Service("memService")
// @Component
// @Component("memService")
// @Repository
// 전부 사용 가능
@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;

	@Override
	public void memberRegister(String memId, String memPw, String memMail, String memPhone1, String memPhone2,
			String memPhone3) {
		System.out.println("memberRegister()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		System.out.println("memMail : " + memMail);
		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);

		dao.memberInsert(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
	}

	@Override
	public Member memberSearch(String memId, String memPw) {
		System.out.println("memberSearch()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);

		Member member = dao.memberSelect(memId, memPw);

		return member;
	}

	@Override
	public void memberModify() {

	}

	@Override
	public void memberRemove() {

	}

}