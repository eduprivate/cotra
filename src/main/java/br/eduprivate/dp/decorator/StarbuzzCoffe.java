package br.eduprivate.dp.decorator;

public class StarbuzzCoffe {
	public static void main(String[] args) {
		Beverage beverage = new Expresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost() );
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost() );
		
	}
}
