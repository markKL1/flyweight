package flyweight.example.misc;

public class Weight {
    public final double weight_g;

    public Weight(double weight_g) {
        assert weight_g >= 0;
        this.weight_g = weight_g;
    }
}
