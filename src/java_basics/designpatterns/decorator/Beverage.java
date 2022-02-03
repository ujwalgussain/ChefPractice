package java_basics.designpatterns.decorator;

public abstract class Beverage {
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();

}
