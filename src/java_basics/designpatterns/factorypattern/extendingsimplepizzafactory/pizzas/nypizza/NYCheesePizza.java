package java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.pizzas.nypizza;

import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.Pizza;

public class NYCheesePizza extends Pizza {
    public NYCheesePizza(){
        setName("NY Cheese Pizza");
        setSauce("NY Pizza Sauce");
    }
}
