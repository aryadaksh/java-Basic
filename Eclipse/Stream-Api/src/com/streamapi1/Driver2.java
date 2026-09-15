package com.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Driver2 {
	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(2,34,12,2,3,2,2,143,43);
		
		List<Integer> greaterThan50 = numbers.stream().filter(num -> num >=50).collect(Collectors.toList());
		System.out.println(greaterThan50);
	}

}
