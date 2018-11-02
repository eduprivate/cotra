package br.eduprivate.dswalgol.stack;

public class StackTest {
	public static Integer[] reverse(Integer[] a) {
		ArrayStack S = new ArrayStack(a.length);
		Integer[] b = new Integer[a.length];
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			S.push(a[i]);
		}
		
		System.out.println("After....");
		
		for (int i = 0; i < a.length; i++) {
			b[i] = (Integer) (S.pop());
			System.out.println(b[i]);
		}
		return b;		
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[5];
		Integer a1 = new Integer(1);
		Integer a2 = new Integer(2);
		Integer a3 = new Integer(3);
		Integer a4 = new Integer(4);
		Integer a5 = new Integer(5);
		
		arr[0] = a1;
		arr[1] = a2;
		arr[2] = a3;
		arr[3] = a4;
		arr[4] = a5;
		
		Integer[] reverse = reverse(arr);
		
		for (int i = 0; i < reverse.length; i++) {
			System.out.println(reverse[i]);
		}
	}
}
