package br.eduprivate.problems_solving;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BonAppetit {
	
	// Complete the solve function below.
    static String solve(int[] bill, int k, int charged) {
    	
    	int total = 0;
    	for (int i = 0; i < bill.length; i++) {
			if (k == i) {
				continue;
			} else {
				total += bill[i];
			}
		}
    	int costPerPerson = total / 2;
    	
    	if (costPerPerson == charged) {
    		return "Bon Appetit";
    	} else {
    		return "" + (charged - costPerPerson);
    	}
    }
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int item = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        int charged = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = solve(ar, item, charged);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}