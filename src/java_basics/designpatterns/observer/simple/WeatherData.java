package java_basics.designpatterns.observer.simple;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Producer of events should implement subject and have a list of Observers
public class WeatherData implements Subject{
    float temp, humidity, pressure;
    List<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:
             observers) {
            observer.update(temp,humidity,pressure);
        }
    }

    //Any Update will be notified
    public void setMeasurements(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
