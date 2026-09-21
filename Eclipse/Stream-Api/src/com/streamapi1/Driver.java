package com.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver
{
	
	public static void main(String[] args)
	{
		//Storing the data
		List<String> citiesName = Arrays.asList("BLR","AHM","AJM","PAT","HYD");
		
		// -> Processing the data -> task to find the name starting with A
		
		// 1. Convert the collection to stream object
		Stream<String> inputStream = citiesName.stream();
		
		//FInd the name starting with "A" -> use filter
		Stream<String> filteredStream = inputStream.filter(w -> w.startsWith("A"));
		
		//3.Collect or print the city Name
		List<String> cityStartWithA = filteredStream.collect(Collectors.toList());
		System.out.println(cityStartWithA);
		
		List<String> cityStartWithA1 = citiesName.stream().filter(w -> w.startsWith("A")).collect(Collectors.toList());
		System.out.println(cityStartWithA1);
		
	}

}
