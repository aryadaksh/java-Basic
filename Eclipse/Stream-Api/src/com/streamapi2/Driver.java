package com.streamapi2;

import java.util.Arrays;
import java.util.List;

 class Driver {
	public static void main(String[] args) {

		List<String> cityName = Arrays.asList("Del", "Pat", "Kol", "Blr", "Jap", "Hyd", "Che", "Pun");

		/*
		 * List<String> result = cityName.stream().distinct() .map(city ->
		 * city.toUpperCase()) .collect(Collectors.toList()) .forEach(e ->
		 * System.out.println(e));
		 */

		/* System.out.println(result); */

		/*
		 * cityName.stream().filter(c -> c.startsWith("D")).skip(1).limit(1).forEach(e
		 * -> System.out.println(e + "!"));
		 */
		
		cityName.stream().sorted().forEach(e -> System.out.println(e +" sorted"));
		

	}

}

 