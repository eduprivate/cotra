package br.eduprivate.dswalgol;

public class PrefixAverages {
	
	public int[] prefixAverages1(int[] x) {
		int ar[] = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			int a = 0;
			for (int j = 0; j < i; j++) {
				a = a+x[j];
				ar[i] = a / (i+1);		
			}
		}
		return ar;
	}
	
	public int[] prefixAverages2(int[] x) {
		int s = 0;
		int ar[] = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			s = s+x[i];
			ar[i] = s / (i+1);
		}
		return ar;
	}
	
	public static void main(String[] args) {
		
	}
}
