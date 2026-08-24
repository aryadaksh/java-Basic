package com.mapexample.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Set;

public class Driver {
	
	public static void main(String[] args) {
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		
		treeMap.put("PHY", 98);
		treeMap.put("Maths", 95);
		treeMap.put("SocialSci", 98);
		treeMap.put("IT", 100);
		// value of PHY will updated 
		treeMap.put("PHY", 99);
		
		
		//sorted order using comparble interface
		//System.out.println(treeMap);
		
		Set<Entry<String,Integer>> enterySet = treeMap.entrySet();
		Iterator<Entry<String,Integer>> itr = enterySet.iterator();
		
		while(itr.hasNext()) {
			Entry res = itr.next();
			System.out.println("Key: "+res.getKey() + " Value:   "+res.getValue());
		}

	}

}
