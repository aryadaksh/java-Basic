package com.streamapi3;

import java.util.List;
import java.util.stream.Collectors;

public class FindFirstNonRepatingChar {

	public static void main(String[] args) {

		String input = "supercalifragilisticexpialidocious";
		
		
		  Character result = input.chars().mapToObj(c -> (char) c).filter(c ->
		  input.indexOf(c) == input.lastIndexOf(c)).findFirst().get();
		 
		 
		/*
		 * List<Character> result = input.chars().mapToObj(c -> (char) c).filter(c ->
		 * input.indexOf(c) ==
		 * input.lastIndexOf(c)).collect(Collectors.toList(),Collectors.
		 * collectingAndThen(null, null));
		 */
		 
		System.out.println(result);

	}
}
