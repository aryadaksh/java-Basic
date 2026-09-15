package com.streamapi3;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountChar {
	public static void main(String[] args) {
		
		String input = "Supercalifragilisticexpialidocious";
		Map<Character,Long> result = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(result);
	}

}
