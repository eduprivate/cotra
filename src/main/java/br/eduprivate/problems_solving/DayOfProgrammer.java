package com.problems_solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DayOfProgrammer {

    // Complete the solve function below.
    static String solve(int year) {
    	int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
    	int total = 0;
    	String result = "";
    	for (int i = 0; i < months.length; i++) {
    		if (i == 1 && year < 1918 ) {
    			if (year % 4 == 0) {
    				total += 29;
    			} else {
    				total += months[i];
    			}
    		} else if (i == 1 && year == 1918 ) {
    			if (year % 4 == 0) {
    				total += 29;
    			} else {
    				total += 15;
    			}
    		} else  {
    			if (i == 1 && year % 400 == 0 || i == 1 && (year % 4 == 0 && year % 100 != 0)) {
    				total += 29;
    			} else {
    				total += months[i];
    			}
    		}
    		
    		if (total >= 230 && total < 256) {
    			int rest = 256 - total;
    			if (rest < 30) {
    				result = rest + "." + String.format("%02d", i+2) + "." + year;
    			} else {
    				int restMonth = months[i+2] - rest;
    				result = restMonth + "." + String.format("%02d", i+2) + "." + year;
    			}
    		}
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}