package java_basics.designpatterns.observer.simple;

public class MainClass {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        //this will register
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(10,20,30);
        currentConditionsDisplay.displayInfo();
        weatherData.setMeasurements(20,30,40);
        currentConditionsDisplay.displayInfo();
    }
}
