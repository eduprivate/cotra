package br.eduprivate.dp.singleton;


public class Singleton2 {
	private static final Singleton2 uniqueInstance = new Singleton2();
	
	private Singleton2() {
	}
	
	public static Singleton2 getInstance() {
		return uniqueInstance;
	}
}
