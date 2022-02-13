package java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.impl;

import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.Pizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.chicagopizza.ChicagoCheesePizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.chicagopizza.ChicagoVeggiePizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.nypizza.NYCheesePizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.nypizza.NYVeggiePizza;
import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzastores.PizzaStore;;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        switch (type){
            case "cheese":
                return new ChicagoCheesePizza();
            case "veggie":
                return new ChicagoVeggiePizza();
            default:
                throw new RuntimeException("Pizza type invalid");
        }
    }
}
