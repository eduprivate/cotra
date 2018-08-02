package br.eduprivate.problems_solving;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class BetweenTwoSets {
	static int lcm(int[] b, int n) {
		int res = 1, i;
		for (i = 0; i < n; i++)
			res = res * b[i] / gcd(res, b[i]);
		return res;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	static int findGCD(int b[], int n) {
		int result = b[0];
		for (int i = 1; i < n; i++)
			result = gcd(b[i], result);
		return result;
	}

	static int getTotalX(int[] a, int[] b) {
		int m, n, count = 0;
		m = lcm(a, a.length);
		n = findGCD(b, b.length);
		for (int i = m, j = 2; i <= n; i = m * j, j++)
			if (n % i == 0)
				count++;
		return count;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = scan.nextLine().split(" ");

		int n = Integer.parseInt(nm[0].trim());

		int m = Integer.parseInt(nm[1].trim());

		int[] a = new int[n];

		String[] aItems = scan.nextLine().split(" ");

		for (int aItr = 0; aItr < n; aItr++) {
			int aItem = Integer.parseInt(aItems[aItr].trim());
			a[aItr] = aItem;
		}

		int[] b = new int[m];

		String[] bItems = scan.nextLine().split(" ");

		for (int bItr = 0; bItr < m; bItr++) {
			int bItem = Integer.parseInt(bItems[bItr].trim());
			b[bItr] = bItem;
		}

		int total = getTotalX(a, b);

		bw.write(String.valueOf(total));
		bw.newLine();

		bw.close();
	}
}
