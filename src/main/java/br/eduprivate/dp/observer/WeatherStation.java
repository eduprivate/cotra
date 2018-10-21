package br.eduprivate.dp.observer;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = 
				new CurrentConditionsDisplay(weatherData);
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 30.4f);
		weatherData.setMeasurements(78, 90, 29.2f);
		currentDisplay.display();
	}
}
