package br.eduprivate.dp.observer;

import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private final ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		int i = this.observers.indexOf(o);
		if (i >= 0) {
			this.observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurements() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

}