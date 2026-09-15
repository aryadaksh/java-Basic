package com.mapexample.cchm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * ConcurrentHashMap is introducde cuz if we do syncorined is locks whole map
 * if we use cchm before java 7 is used to have segment locking in which its used to lock that specific bucket
 * after java 7 its use CAS Compare and sweep in which its not lock its internally compare and sweep if we do updates then
 */

public class ConcurrentHashMapExample {
	
	public static void main(String[] args) {
		
		Map<String,Integer> concurrentHashMap = new ConcurrentHashMap<String,Integer>();
		concurrentHashMap.put("Iphone", 98765);
		concurrentHashMap.put("Samsung", 52323);
		concurrentHashMap.put("Google", 90876);
		concurrentHashMap.put("Moto", 98765567);
		concurrentHashMap.put("Huwai", 90876543);
		
		System.out.println(concurrentHashMap);
		
		
		
		
		
	}

}
