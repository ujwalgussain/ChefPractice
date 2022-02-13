package java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.impl.nypizza;

import java_basics.designpatterns.factorypattern.extendingpizzastore.pizzas.*;

import java.util.ArrayList;
import java.util.List;

public class NYVeggiePizza extends Pizza {
    public NYVeggiePizza(){
        setName("NY Veggie Pizza");
        setToppings(new ArrayList(List.of("onion","corn","capsicum","mushrooms"))); //NY Store Puts Mushrooms in VeggiePizza
    }
}
