import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FinalAndIntermediary {

    public static void main(String[] args) {

        Stream<String> s1 = Stream.of("one","two","three","five","six");
        Stream<String> s2 = Stream.of("one","two","three","five","six");

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        Consumer<String> print = System.out::println;

        List<String> result = new ArrayList<>();

        s1
                .peek(print)
                .filter(p1.or(p2))
                .peek(result::add);

        result.forEach(print);
        System.out.println("DONE first step");
        s2
                .peek(print)
                .filter(p1.or(p2))
                .forEach(result::add);

        System.out.println("Done second step");
        result.forEach(print);




    }
}
