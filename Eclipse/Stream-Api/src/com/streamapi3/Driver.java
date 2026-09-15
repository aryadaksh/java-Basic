
package com.streamapi3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver {
	
	public static void main(String[] args) {
		
		List<String> cityName= Arrays.asList("Hyderabad","Surat","Mysore","Hampi","Chennai","Jaipur","Noida","Bangalore","Gurugram","Chennai","New Delhi","Mumbai","Ahmedabad");
		
		
		long countValue = cityName.stream().collect(Collectors.counting());
		System.out.println("Count of city: "+countValue);
		
		Map<Object,List<String>>   result =cityName.stream().collect(Collectors.groupingBy(city -> city.length()));
		System.out.println(result);
	}

}
