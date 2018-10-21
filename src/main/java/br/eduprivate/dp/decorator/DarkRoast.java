package br.eduprivate.dp.decorator;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		this.description = "DarkRoast";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}
}
