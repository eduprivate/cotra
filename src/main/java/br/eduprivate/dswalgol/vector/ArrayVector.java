package br.eduprivate.dswalgol.vector;

public class ArrayVector {
	private Object[] a;
	private int capacity = 16;
	private int size = 0;
	public ArrayVector() {a = new Object[capacity];}
	public Object elemAtRank(int r) {return a[r];}
	public int size() {return size;}
	public boolean isEmpty() {return size() == 0;}
	
	public Object replaceAtRank(int r, Object e) {
		Object temp = a[r];
		a[r] = e;
		return temp;
	}
	
	public Object removeAtRank(int r) {
		Object temp = a[r];
		for (int i = r; i < size; i++) {
			a[i] = a[i+1];	
		}
		size--;
		return temp;
	}
	
	public void insertAtRank(int r, Object e) {
		if (size == capacity) {
			capacity *= 2;
			Object[] b = new Object[capacity];
			for (int i = 0; i < size; i++) {
				b[i] = a[i];
			}
			a = b;
		}
		for (int i = size-1; i > r; i--) {
			a[i+1] = a[i];
			a[r] = e;
			size++;
		}
	}
}
