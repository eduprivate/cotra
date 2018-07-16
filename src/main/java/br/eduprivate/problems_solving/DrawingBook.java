package com.problems_solving;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
	static int pageCount(int n, int p) {
        int[] book = new int[n];
        int fromBegin = -1;
        for (int i = 0; i < book.length; i+=2) {
            if (!(p == i) || !(p == i+1)) {
                fromBegin++;
            }
            if ((p == i) || (p == i+1)) {
                break;
            }
        }
        int fromEnd = -1;
        for (int i = book.length; i >= 0; i-=2) {
        	if (n % 2 == 0 && i == n) {
        		if (!(p == i)) {
                    fromEnd++;
                }
                if ((p == i)) {
                	fromEnd=0;
                    break;
                }
        	} 
        	else if (!(p == i) || !(p == i-1)) {
                fromEnd++;
            }
            if ((p == i) || (p == i-1)) {
            	fromEnd++;
                break;
            }
        }
        
        if (fromBegin <= fromEnd) {
            return fromBegin;
        }    
        else {
            return fromEnd;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}