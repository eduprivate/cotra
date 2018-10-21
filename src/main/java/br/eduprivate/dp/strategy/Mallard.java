package br.eduprivate.dp.strategy;

public class Mallard extends Duck {
	
	public Mallard() {
		super.flyBehavior = new FlyWithWings();
		super.quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}

}
