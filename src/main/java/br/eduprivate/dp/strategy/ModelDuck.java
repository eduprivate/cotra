package br.eduprivate.dp.strategy;

public class ModelDuck extends Duck {
	
	public ModelDuck() {
		super.flyBehavior = new FlyWithWings();
		super.quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}
}
