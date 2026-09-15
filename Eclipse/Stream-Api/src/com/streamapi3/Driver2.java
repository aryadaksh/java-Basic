package com.streamapi3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver2 {
	public static void main(String[] args) {
		
		List<Integer> input = Arrays.asList(12,213,321,342,45,534,65,65,45,875,664,86798,4,56,65,35,87,89,98,4654,35,42,3);
		
		Map<Boolean,List<Integer>> output = input.stream().collect(Collectors.partitioningBy(n -> n%2!=0));
		System.out.println(output);
	}

}
