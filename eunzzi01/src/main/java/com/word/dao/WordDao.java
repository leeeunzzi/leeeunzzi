package com.word.dao;

import java.util.HashMap;
import java.util.Map;

import com.word.WordSet;

public class WordDao {
	
	// 아직 디비 연결 안했으니 Map 데이터 타입으로 대체
	private Map<String, WordSet> wordDB = 
			new HashMap<String, WordSet>();

	public void insert(WordSet wordSet) {
		wordDB.put(wordSet.getWordKey(), wordSet);
	}

	public WordSet select(String wordKey) {
		return wordDB.get(wordKey);
	}

	public void update(WordSet wordKey) {
		wordDB.put(wordKey.getWordKey(), wordKey);
	}

	public void delete(String sNum) {
		wordDB.remove(sNum);
	}

	public Map<String, WordSet> getWordDB() {
		return wordDB;
	}

}