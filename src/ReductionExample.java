import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
    public static void main(String[] args) {

       java.util.List<Integer> list = Arrays.asList(10,20,30);

       Integer red= list
                        .stream()
                        .reduce(0,Integer::sum);
        System.out.println(red);

        List<Integer> list2 = Arrays.asList(22,24);

        Optional<Integer> reduce = list2
                .stream()
                .reduce(Integer::max);

        System.out.println(reduce.orElseThrow(RuntimeException::new));
    }
}
