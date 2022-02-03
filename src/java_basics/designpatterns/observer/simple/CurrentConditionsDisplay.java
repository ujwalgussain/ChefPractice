package java_basics.designpatterns.observer.simple;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    float temp, humidity, pressure;
    Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this); //register
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public void displayInfo() {
        System.out.printf("CurrentConditionsDisplay [temp = %s, humidity =%s, pressure = %s]\n",temp,humidity,pressure);
    }
}
