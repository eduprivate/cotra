package br.eduprivate.dswalgol.array;

public class ArrayMaxProgram {
	static int arrayMax(int[] A, int n) {
		int currentMax = A[0];
		for (int i = 1; i < n; i++) {
			if (currentMax < A[i])
				currentMax = A[i];
		}
		return currentMax;
	}
	
	public static void main(String[] args) {
		
		int[] num = {10, 15, 3, 5, 56, 107, 22, 16, 85};
		int n = num.length;
		
		System.out.println("Array: " );
		for (int i = 0; i < n; i++) {
			System.out.println(" " + num[i]);
		}
		
		System.out.println(".");
		System.out.println("The maximum element is " + arrayMax(num, n)+ ".");
		
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			int[] arr = new int[i];
			for (int k = 0; k < arr.length; k++) {
				int r = (int) (Math.random() * (1000 - 1)) + 1;
				arr[k] = r;
			}
			int max = arr.length;
			
			System.out.println("Array: " );
			for (int j = 0; j < max; j++) {
				System.out.println(" " + arr[j]);
			}
			
			System.out.println(".");
			System.out.println("The maximum element is " + arrayMax(arr, max)+ ".");
		}
	}
}
