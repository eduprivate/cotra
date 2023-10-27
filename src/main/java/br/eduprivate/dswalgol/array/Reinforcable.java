package br.eduprivate.dswalgol.array;

public class Reinforcable {
	
	public static void exe1(int n) {
		int a;
		for (int i = 0; i < n; i++) {
			a = i;
		}
	}
	
	public static void exe2(int n) {
		int a;
		for (int i = 0; i < n; i+=2) {
			a = i;
		}
	}
	
	public static void exe3(int n) {
		int a;
		for (int i = 0; i < n*n; i++) {
			a = i;
		}
	}
	
	public static void exe4(int n) {
		int a;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				a = i;				
			}
		}
	}
	
	public static void exe5(int n) {
		int a;
		for (int i = 0; i < n*n; i++) {
			for (int j = 0; j <= i; j++) {
				a = i;				
			}
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Reinforcable.exe1(1000000);
		long end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
		
		start = System.currentTimeMillis();
		Reinforcable.exe2(1000000);
		end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
		
		start = System.currentTimeMillis();
		Reinforcable.exe3(1000000);
		end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
		
		start = System.currentTimeMillis();
		Reinforcable.exe4(1000000);
		end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
		
		start = System.currentTimeMillis();
		Reinforcable.exe5(1000000);
		end = System.currentTimeMillis();
		System.out.println("Process toke: " + (end - start));
	}
	
}
