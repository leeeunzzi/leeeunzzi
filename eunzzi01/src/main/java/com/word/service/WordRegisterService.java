package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {

	@Autowired
	@Qualifier("usedDao")
	private WordDao wordDao;

	// 생성자에 자동주입하는 Autowired는 그냥 쓰면 되나
	// 프로퍼티나 메소드에 Autowired 사용시 반드시 default 생성자 명시해줘야함
	
	  public WordRegisterService() {
	  }

	//@Autowired
	// appCtxUseAutowired.xml 파일에서 constructor-arg 따로 작성해주지 않아도 됨
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if (verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}

	// 중복단어 검증
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}

	// @Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}