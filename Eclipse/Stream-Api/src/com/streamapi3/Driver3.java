package com.streamapi3;

import java.util.List;
import java.util.stream.Collectors;

public class Driver3 {

	public static void main(String[] args) {
		String input = "Hello";

		// chars -> Returns a stream of int zero-extending the char values from this
		// sequence. Any char which maps to a * Character##unicode surrogate code point
		// is passed through uninterpreted.

		List<Character> output = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		System.out.println(output);

	}
}
