package flyweight.injava;

public class Ints {
    public static void main(String[] args) {
        Integer a = 127, b = 127;
        System.out.println(a == b);
        // true
        Integer c = 128, d = 128;
        System.out.println(c ==  d);
        // false
    }
}
