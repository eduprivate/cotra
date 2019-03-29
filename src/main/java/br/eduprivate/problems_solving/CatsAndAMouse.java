package br.eduprivate.problems_solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CatsAndAMouse {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
    	
    	int maxA = 0;
    	int maxB = 0;
    	
    	if (x < z) {
    		while(x < z) {
    			maxA++;
    			x++;
    		}
    	} else if (x > z) {
    		while(x > z) {
    			maxA++;
    			x--;
    		}
    	}
    	
    	if (y < z) {
    		while(y < z) {
    			maxB++;
    			y++;
    		}
    	} else if (y > z) {
    		while(y > z) {
    			maxB++;
    			y--;
    		}
    	}
    	
    	if (maxA == maxB) {
    		return "Mouse C";
    	} if (maxA > maxB) {
    		return "Cat B";
    	} 	
    	
    	return "Cat A";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}