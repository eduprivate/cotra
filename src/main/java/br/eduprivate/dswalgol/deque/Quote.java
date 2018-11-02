package br.eduprivate.dswalgol.deque;

public class Quote {
	
	private int day, price, span;
	
	public Quote(int d, int p) {
		setDay(d);
		setPrice(p);
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setSpan(int span) {
		this.span = span;
	}
	
	public int getSpan() {
		return span;
	}
}
