package com.brms.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.member.Member;
import com.brms.member.dao.MemberDao;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { }
	
	public void register(Member member) {
		memberDao.insert(member);
	}
	
	public void initMethodMember() {
		System.out.println("initMethodMember 호출 됐다");
	}
	
	public void destroyMethodMemeber() {
		System.out.println("destroyMethodMemeber 호출 됐다");
	}
}
