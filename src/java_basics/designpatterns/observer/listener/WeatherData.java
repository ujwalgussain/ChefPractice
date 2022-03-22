package java_basics.designpatterns.observer.listener;

import java_basics.designpatterns.observer.simple.Observer;
import java_basics.designpatterns.observer.simple.Subject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;

public class WeatherData implements Subject {
    List<Observer> observerList;

    //Data to be updated
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherData() {
        observerList = new ArrayList<>();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        notifyObservers();
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:
             observerList) {
            observer.update(temperature,humidity,pressure);
        }
    }
}
