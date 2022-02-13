package java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.impl;

import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.nypizza.NYCheesePizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.nypizza.NYVeggiePizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.*;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        switch (type){
            case "cheese":
                return new NYCheesePizza();
            case "veggie":
                return new NYVeggiePizza();
            default:
                throw new RuntimeException("Pizza type invalid");
        }
    }
}
