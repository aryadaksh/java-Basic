package com.setexample.hashset;

import java.util.Set;
import java.util.HashSet;

public class Driver {

	public static void main(String[] args) {
		Set<String> product = new HashSet<String>();

		product.add("iPhone17");
		product.add("samsungs26");
		product.add("lg32");
		product.add("mac-pro324");

		System.out.println(product);

		System.out.println("==========================================================");

		for (String pro : product) {
			int hash = pro.hashCode();
			int spreadHash = hash ^ (hash >>> 16);
			int bucket = spreadHash & 15;
			System.out.println(pro + " hash code " + hash + " Bucket: " + bucket);
		}

		System.out.println(product.contains("iPhone17"));

	}

}
