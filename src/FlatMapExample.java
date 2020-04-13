import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(8,9,10);
        List<Integer> list3 = Arrays.asList(11,12,13,14);

        List<List<Integer>> List1 = Arrays.asList(list1,list2,list3);
        List<List<Integer>> List2 = Arrays.asList(list1,list2,list3);
        List<List<Integer>> List3 = Arrays.asList(list1,list2,list3);

        Consumer<?> print = System.out::println;

        List2.forEach((Consumer< List<Integer>>) print);

        Function<List<?>,Integer> size = List::size;

        Function<List<Integer>, Stream<Integer>> flatmapper = l ->l.stream();

        List1
                .stream()
                .map(size)
                .forEach((Consumer< Integer>) print);
        System.out.println();

        List3
                .stream()
                .flatMap(flatmapper)
                .forEach((Consumer<Integer>) print);

        List<Integer> sizelist =List2
                .stream()
                .flatMap(s-> Stream.of(s.size()))
                .collect(Collectors.toList());

        System.out.println(sizelist);
    }
}
