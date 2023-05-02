package br.eduprivate.problems_solving;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
    	Map<Integer, Integer> occ = new HashMap<>();
    	for (int i = 0; i < ar.length; i++) {
			if (occ.containsKey(ar[i])) {
				Integer value = occ.get(ar[i]);
				value++;
				occ.put(ar[i], value);
			} else {
				occ.put(ar[i], 1);
			}
		}
    	
    	int max = 0;
    	int key = 0;
    	
    	for (Map.Entry<Integer, Integer> entry : occ.entrySet()) {
    	    Integer k = entry.getKey();
    	    Integer m = entry.getValue();
    	    
			if (m > max) {
				max = m;
				key = k;
			}
    	}
    	
    	return key;	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
