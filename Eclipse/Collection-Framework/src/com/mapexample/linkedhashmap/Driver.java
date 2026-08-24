package com.mapexample.linkedhashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Driver {

	public static void main(String[] args) {
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		
		linkedHashMap.put("PHY", 98);
		linkedHashMap.put("Maths", 95);
		linkedHashMap.put("SocialSci", 98);
		linkedHashMap.put("IT", 100);
		// value of PHY will updated 
		linkedHashMap.put("PHY", 99);
		
		
		// output as insterstion order internally using hashing and doubly ll for maintaing insertion order
	//	System.out.println(linkedHashMap);
		
		Set<Entry<String,Integer>> enterySet = linkedHashMap.entrySet();
		Iterator<Entry<String,Integer>> itr = enterySet.iterator();
		
		while(itr.hasNext()) {
			Entry res = itr.next();
			System.out.println("Key: "+res.getKey() + " Value:   "+res.getValue());
		}
	}
}
