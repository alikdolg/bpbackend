package com.backend.task.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CountersService {

	private Map<String, MutableInt> words = new HashMap<String, MutableInt>();
	private Map<String, MutableInt> types = new HashMap<String, MutableInt>();
	
	public void countWords(String word) {
		MutableInt count = words.get(word);
		if (count == null) {
			words.put(word, new MutableInt());
		}
		else {
		    count.increment();
		}
	}
	
	public void countTypes(String type) {
		MutableInt count = types.get(type);
		if (count == null) {
			types.put(type, new MutableInt());
		}
		else {
		    count.increment();
		}
	}
	
	private String printMap(Map<String, MutableInt> counters) {
		StringBuffer strb = new StringBuffer();
		counters.entrySet().forEach(entry -> {strb.append(entry.getKey() + " -> " + entry.getValue().get() +", ");});
		return strb.toString().substring(0, strb.length()-2);
	}
	
	public String printTypes() {
		return printMap(types);
	}
	
	public String printWords() {
		return printMap(words);
	}
	
	class MutableInt {
		int value = 1;
		public void increment () { ++value;      }
		public int  get ()       { return value; }
	}
}
