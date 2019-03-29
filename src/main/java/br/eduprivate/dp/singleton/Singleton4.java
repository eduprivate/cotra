package br.eduprivate.dp.singleton;

public class Singleton4 {

	private static Singleton4 uniqueInstance;

	private Singleton4() {
	}

	public static synchronized Singleton4 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton4();
		}
		return uniqueInstance;
	}
}
