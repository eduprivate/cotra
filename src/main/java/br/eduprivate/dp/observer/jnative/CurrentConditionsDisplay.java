package br.eduprivate.dp.observer.jnative;

import java.util.Observable;
import java.util.Observer;

import br.eduprivate.dp.observer.DisplayElement;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	
	Observable observable;
	private float temperature;
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature +
				"F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData weatherData) {
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}
}
