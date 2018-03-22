package flyweight.example.before;

import java.awt.*;

import flyweight.example.misc.Price;
import flyweight.example.misc.Weight;

public class Fruit {
    // Common fields
    private final String name;
    private final Color color;

    // Object-specific fields
    private final Weight weight;
    private final Price price;

    // Factory function.
    public static Fruit make(String name, Color color, Weight weight, Price price) {
        assert name != null && color != null && weight != null && price != null;
        return new Fruit(name, color, weight, price);
    }

    // Private because `make` should be used.
    private Fruit(String name, Color color, Weight weight, Price price) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Weight getWeight() {
        return weight;
    }

    public Price getPrice() {
        return price;
    }
}
