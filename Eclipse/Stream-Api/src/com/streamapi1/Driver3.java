package com.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Driver3 {
	
	public static void main(String[] args)
	{
		List<List<String>> citiesName = Arrays.asList(Arrays.asList("BLR","AHM"),Arrays.asList("AJM","PAT"),Arrays.asList("HYD"));
		
		List<String> cites = citiesName.stream()
									   .flatMap(list -> list.stream())
									   .filter(word -> word.startsWith("A"))
									   .map(word -> word.toUpperCase())
									   .collect(Collectors.toList());
		
		System.out.println(cites);
		
	}

}
