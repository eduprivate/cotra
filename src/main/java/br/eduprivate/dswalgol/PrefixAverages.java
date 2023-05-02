package br.eduprivate.dswalgol;

public class PrefixAverages {
	
	public static int[] prefixAverages1(int[] x) {
		int[] ar = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			int a = 0;
			for (int j = 0; j < i; j++) {
				a = a+x[j];
				ar[i] = a / (i+1);		
			}
		}
		return ar;
	}
	
	public static int[] prefixAverages2(int[] x) {
		int s = 0;	
		int[] ar = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			s = s+x[i];
			ar[i] = s / (i+1);
		}
		return ar;
	}
	
	public static void main(String[] args) {
		int max = 100000;
		int[] arr =  new int[max];	
		
		for(int i = 0; i < max; i++)
			arr[i] = i;
		
		long start = System.currentTimeMillis();
		System.out.println(prefixAverages1(arr));
		long end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
		
		start = System.currentTimeMillis();
		System.out.println(prefixAverages2(arr));
		end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
	}
}
