package com.streamapi1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args)
	{
		List<Integer> numbers = Arrays.asList(2,3,4,5,6,7,8,9,10);
		
		List<Integer> result = numbers.stream().filter(num -> num>5).map(num -> num*-1).collect(Collectors.toList());
		System.out.println(result);
		
		List<Character> chare = Arrays.asList('A','c','D','g','p');
		
		List<Character> charToUper = chare.stream().map(ch -> ch.toUpperCase(ch)).collect(Collectors.toList());
		System.out.println(charToUper);
		
	}
}
