package flyweight.example.misc;

public class Price {
    public final int euro;
    public final int cents;

    public Price(int euro, int cents) {
        assert cents >= 0;
        assert cents < 99;
        this.euro = euro;
        this.cents = cents;
    }
}
