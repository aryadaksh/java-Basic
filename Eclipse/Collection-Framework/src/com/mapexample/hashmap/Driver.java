package com.mapexample.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Driver {
	
	public static void main(String[] args) {
		Map<String, Integer> mp = new HashMap<String, Integer>();
		
		mp.put("PHY", 98);
		mp.put("Maths", 95);
		mp.put("SocialSci", 98);
		mp.put("IT", 100);
		// value of PHY will updated 
		mp.put("PHY", 99);
		
		//System.out.println(mp);
		
		Set<Entry<String,Integer>> enterySet = mp.entrySet();
		
		Iterator<Entry<String,Integer>> itr = enterySet.iterator();
		
		while(itr.hasNext()) {
			Entry res = itr.next();
			System.out.println("Key: "+res.getKey() + " Value:   "+res.getValue());
		}
	
	}

}
