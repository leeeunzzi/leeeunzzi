package com.pjt.pjtex.member;

// 필드명 = view에 존재하는 각 input 태그의 name 속성값
public class Member {
	// 커맨드객체
	private String memId;
	private String memPw;
	private String memMail;
	private String memPhone1;
	private String memPhone2;
	private String memPhone3;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public String getMemPhone1() {
		return memPhone1;
	}

	public void setMemPhone1(String memPhone1) {
		this.memPhone1 = memPhone1;
	}

	public String getMemPhone2() {
		return memPhone2;
	}

	public void setMemPhone2(String memPhone2) {
		this.memPhone2 = memPhone2;
	}

	public String getMemPhone3() {
		return memPhone3;
	}

	public void setMemPhone3(String memPhone3) {
		this.memPhone3 = memPhone3;
	}
}
