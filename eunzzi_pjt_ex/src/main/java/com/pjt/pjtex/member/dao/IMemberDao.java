package com.pjt.pjtex.member.dao;

import com.pjt.pjtex.member.Member;

public interface IMemberDao {
	void memberInsert(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);

	Member memberSelect(String memId, String memPw);

	void memberUpdate();

	void memberDelete();
}
