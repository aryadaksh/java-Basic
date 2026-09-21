package com.streamapi.types;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Daksh" ,"Arya","Daiwik","Suman","Masood");
		
		List<String> startWithD = list.parallelStream().filter(e -> e.startsWith("D")).collect(Collectors.toList()); // its internally implements ForkJoinPool
		System.out.println(startWithD);
		
		List<String> startWithD1 = list.stream().parallel().filter(e -> e.startsWith("D")).collect(Collectors.toList());
		System.out.println(startWithD1);
	}

}
