import java.util.*;

public class StreamTest {

    public static List<Double> getDoubleList(int size) {
        Random rand = new Random();
        List<Double> randomDoubles = new ArrayList<Double>();

        for (int i = 0; i < size; i++) {
            randomDoubles.add(rand.nextDouble());
        }

        return randomDoubles;
    }

    public static void testStreams1(){

        System.out.println("---Test 1: Product of Doubles (reduce)---");

        List<Double> randomDoubles = getDoubleList(20);

        Set<Double> serialProductSet = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            Double serialProduct = randomDoubles
                    .stream()
                    .reduce((x,y) -> x*y)
                    .get();
            serialProductSet.add(serialProduct);
        }

        System.out.println("Serial product: " + serialProductSet);

        Set<Double> parallelProductSet = new HashSet<>();

        for (int j = 0; j < 1000; j++) {
            parallelProductSet.add(randomDoubles
                    .parallelStream()
                    .reduce((x,y) -> x*y)
                    .get());
        }

        System.out.println("Parallel product: " + parallelProductSet);

        System.out.println();

    }

    public static void testStreams2() {

        System.out.println("---Test 2: Product of Doubles (forEach)---");

        List<Double> randomDoubles = getDoubleList(20);

        Set<Double> serialProductSet = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            var wrapper1 = new Object(){Double serialProduct = 1.0;};
            randomDoubles.stream().forEach(x -> {wrapper1.serialProduct *= x;});
            serialProductSet.add(wrapper1.serialProduct);
        }

        System.out.println("Serial product: " + serialProductSet);

        Set<Double> parallelProductSet = new HashSet<>();

        for (int j = 0; j < 1000; j++) {
            var wrapper2 = new Object(){Double serialProduct = 1.0;};
            randomDoubles.parallelStream().forEach(x -> {wrapper2.serialProduct *= x;});
            parallelProductSet.add(wrapper2.serialProduct);
        }

        System.out.println("Parallel product: " + parallelProductSet);

        System.out.println();

    }

    public static void testStreams3() {

        System.out.println("---Test 3: Sum of Doubles (reduce)---");

        List<Double> randomDoubles = getDoubleList(20);

        Set<Double> serialSumSet = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            Double serialSum = randomDoubles
                    .stream()
                    .reduce(Double::sum)
                    .get();
            serialSumSet.add(serialSum);
        }

        System.out.println("Serial sum: " + serialSumSet);

        Set<Double> parallelSumSet = new HashSet<>();

        for (int j = 0; j < 1000; j++) {
            parallelSumSet.add(randomDoubles
                    .parallelStream()
                    .reduce(Double::sum)
                    .get());
        }

        System.out.println("Parallel sum: " + parallelSumSet);

        System.out.println();

    }

    public static void testStreams4() {

        System.out.println("---Test 4: Sum of Doubles (forEach)---");

        List<Double> randomDoubles = getDoubleList(20);

        Set<Double> serialSumSet = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            var wrapper = new Object(){Double serialProduct = 1.0;};
            randomDoubles.stream().forEach(x -> {wrapper.serialProduct += x;});
            serialSumSet.add(wrapper.serialProduct);
        }

        System.out.println("Serial sum: " + serialSumSet);

        Set<Double> parallelProductSet = new HashSet<>();

        for (int j = 0; j < 1000; j++) {
            var wrapper = new Object(){Double serialProduct = 1.0;};
            randomDoubles.parallelStream().forEach(x -> {wrapper.serialProduct += x;});
            parallelProductSet.add(wrapper.serialProduct);
        }

        System.out.println("Parallel sum: " + parallelProductSet);

        System.out.println();

    }

    public static void main(String[] args) {
        testStreams1();
        testStreams2();
        testStreams3();
        testStreams4();
    }

}
