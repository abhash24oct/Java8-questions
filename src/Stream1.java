import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {

        Stream<String> s1 = Stream.of("one","two","three","five","six");
        Stream<String> s2= Stream.of("one","two","three","five","six");
        Consumer<String> print = System.out::println;
        Predicate<String> p1 = p -> p.length()>3;

        System.out.println("-------Filtered Stream with string size greater than 3 ------------------");
        s1
                .filter(p1)
                .forEach(print);

        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        System.out.println("-------Filtered Stream with value two or three ------------------");
        s2
                .filter(p2.or(p3))
                .forEach(print);


    }
}
