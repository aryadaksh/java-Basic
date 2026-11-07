package com.snapdeal.util;

import java.util.Scanner;

public final class AppScanner {

    private static final Scanner SCANNER =
            new Scanner(System.in);

    private AppScanner() {
    	//util class
    }

    public static Scanner getScanner() {

        return SCANNER;
    }
}