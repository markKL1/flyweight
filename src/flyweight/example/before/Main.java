package flyweight.example.before;

import java.awt.*;

import flyweight.example.misc.Price;
import flyweight.example.misc.Weight;

public class Main {
    public static void main(String[] args) {
        Fruit.make("Banana", Color.YELLOW, new Weight(250), new Price(0,19));
        Fruit.make("Apple",  Color.RED,    new Weight(520), new Price(0,59));
        Fruit.make("Apple",  Color.RED,    new Weight(610), new Price(0,99));
        Fruit.make("Apple",  Color.RED,    new Weight(450), new Price(0,49));
        Fruit.make("Apple",  Color.RED,    new Weight(300), new Price(0,15));
        Fruit.make("Banana", Color.YELLOW, new Weight(190), new Price(0,15));
        Fruit.make("Banana", Color.YELLOW, new Weight(260), new Price(0,21));
    }
}
