package java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl;

import java_basics.designpatterns.factorypattern.extendingsimplepizzafactory.Pizza;

import java.util.ArrayList;
import java.util.List;

public class VeggiePizza extends Pizza {
    public VeggiePizza(){
        setName("Veggie Pizza");
        setToppings(new ArrayList(List.of("onion","corn","capsicum")));
    }
}
