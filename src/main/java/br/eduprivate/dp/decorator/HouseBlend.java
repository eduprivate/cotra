package br.eduprivate.dp.decorator;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		this.description = "House blend Coffe";
	}

	@Override
	public double cost() {
		return 0.89;
	}

}
