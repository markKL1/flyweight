package flyweight.example.after;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import flyweight.example.misc.Price;
import flyweight.example.misc.Weight;

public class Fruit {
    // Common data moved to shared class
    private final FruitShared shared;

    // Object-specific fields
    private final Weight weight;
    private final Price price;

    // Factory function.
    public static Fruit make(String name, Color color, Weight weight, Price price) {
        assert name != null && color != null && weight != null && price != null;
        return new Fruit(FruitShared.make(name, color), weight, price);
    }

    // Private because `make` should be used.
    private Fruit(FruitShared shared, Weight weight, Price price) {
        this.shared = shared;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return shared.name;
    }

    public Color getColor() {
        return shared.color;
    }

    public Weight getWeight() {
        return weight;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        // We can use == here because it's interned!
        return this.shared == fruit.shared &&
                Objects.equals(this.weight, fruit.weight) &&
                Objects.equals(this.price,  fruit.price);
    }
}

class FruitShared {
    // Common fields
    final String name;
    final Color color;

    // Package-private because `make` should be used
    FruitShared(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    // Get existing value or create one and cache it
    public static FruitShared make(String name, Color color) {
        return FruitShareCache.getInstance().intern(name, color);
    }

    // Needs hashCode to be cached
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitShared that = (FruitShared) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(color, that.color);
    }

    public static int hash(String name, Color color) {
        return name.hashCode() + 37 * color.hashCode();
    }

    @Override
    public int hashCode() {
        return hash(name, color);
    }
}

class FruitShareCache {
    private static FruitShareCache instance = new FruitShareCache();
    private Map<Integer, FruitShared> cache = new HashMap<>();

    public FruitShared intern(String name, Color color) {
        int hash = FruitShared.hash(name, color);
        if (!cache.containsKey(hash)) {
            FruitShared share = new FruitShared(name, color);
            cache.put(hash, share);
        }
        return cache.get(hash);
    }

    public static FruitShareCache getInstance() {
        return instance;
    }
}

