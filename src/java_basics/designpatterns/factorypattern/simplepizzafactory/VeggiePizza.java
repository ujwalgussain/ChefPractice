package java_basics.designpatterns.factorypattern.simplepizzafactory;

import java.util.ArrayList;
import java.util.List;

public class VeggiePizza extends Pizza {
    public VeggiePizza(){
        this.name = "Veggie Pizza";
        this.toppings = new ArrayList(List.of("onion","corn","capsicum"));
    }
}
