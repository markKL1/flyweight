package flyweight.injava;

import java.util.concurrent.ThreadLocalRandom;

public class Text {
    private final int N = 1_000_000;
    private final String[] data = new String[N];
    private Runtime runtime;
    private long baseline;

    public static void main(String[] args) {
        new Text().measure();
    }

    private void measure() {

        // Actually, 63*1000000/1024/1024 = 60MB...

        // No interning
        startBenchmark();
        for (int k = 0; k < N; k++) {
            data[k] = new String("Design Patterns - " +
                "Elements of Reusable Object-Oriented Software");
        }
        endBenchmark();

        // Interning
        startBenchmark();
        for (int k = 0; k < N; k++) {
            data[k] = new String("Design Patterns - " +
                "Elements of Reusable Object-Oriented Software").intern();
        }
        endBenchmark();

        // Literals
        startBenchmark();
        for (int k = 0; k < N; k++) {
            data[k] = "Design Patterns - " +
                "Elements of Reusable Object-Oriented Software";
        }
        endBenchmark();
    }

    private void startBenchmark() {
        for (int k = 0; k < N; k++) {
            data[k] = null;
        }
        System.gc();  // not guaranteed

        if (runtime == null) {
            runtime = Runtime.getRuntime();
        }
        baseline = runtime.totalMemory() - runtime.freeMemory();
    }

    private String endBenchmark() {
        System.gc();  // not guaranteed
        System.out.printf("%.2f MB\n", (runtime.totalMemory() - runtime.freeMemory() - baseline) / 1024. / 1024.);

        return data[ThreadLocalRandom.current().nextInt(0, N)];
    }
}
