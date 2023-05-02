package br.eduprivate.problems_solving;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CountingValleys {

    static int countingValleys(int n, String s) {

    	char[] steps = s.toCharArray();
    	
    	int countValey = 0;
    	int level = 0;
    	boolean inValley = false;
    	for (int i = 0; i < steps.length; i++) {
			if (steps[i] == 'D') {
				level--;
			} else {
				level++;
			}
			
			if (!inValley && level<0) {
				inValley = true;
				countValey++;
			} else if (level >= 0) {
				inValley = false;
			} 
		}
    	return countValey;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}