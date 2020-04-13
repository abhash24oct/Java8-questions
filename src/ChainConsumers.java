import java.util.*;
import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("one","two","three");

        List<String>  result = new ArrayList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String>  c2 = result::add;

        strings.forEach(c1.andThen(c2));

        result.forEach(c1);



    }
}
