package br.eduprivate.problems_solving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BirthdayChocolate {

    // Complete the solve function below.
    static int solve(int[] s, int d, int m) {
    	int ways = 0;
        int sum = 0;
        if(m <= s.length) 
            for(int i = 0; i < m; i++)
                sum += s[i];
        if(sum == d) ways++;

        for(int i = 0; i < s.length-m; i++)
        {
            sum = sum - s[i] + s[i+m];
            if(sum == d) ways++;
        }
        return ways;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] s = new int[n];

        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sItems[i]);
            s[i] = sItem;
        }

        String[] dm = scanner.nextLine().split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = solve(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
