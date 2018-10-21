package br.eduprivate.dp.decorator;

public class Expresso extends Beverage {
	
	public Expresso() {
		this.description = "Expresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}
}
