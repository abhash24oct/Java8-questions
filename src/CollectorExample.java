import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorExample {
    public static void main(String[] args) throws IOException {

        List<Person> person = new ArrayList<>();

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(CollectorExample.class.getResourceAsStream("people.txt")));
                Stream<String> stream = reader.lines();
        ){
            ComparatorExample.readPersonFile(person, stream);
        }


        Optional<Person> min = person
                .stream()
                .filter(p -> p.getAge() > 20)
                .min(Comparator.comparing(Person::getAge));

        System.out.println(min);

        Optional<Person> max =person
                .stream()
                .max(Comparator.comparing(Person::getAge));

        System.out.println(max);

        List<Integer> ages= person
                .stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        System.out.println("----------AGES--------------");
        ages.forEach(s-> System.out.print(s+","));


        System.out.println("----------Grouping based n ages--------------");
        Map<Integer, List<Person>> collect = person
                .stream()
                .filter(p -> p.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(collect);

        Map<Integer, Long> collect2 = person
                .stream()
                .filter(p -> p.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));

        System.out.println(collect2);

        Map<Integer, List<String>> collect3 = person
                .stream()
                .filter(p -> p.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList())));

        System.out.println(collect3);

        Map<Integer, String> collect4 = person
                .stream()
                .filter(p -> p.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.joining(","))));

        System.out.println(collect4);

        Map<Integer, Set<String>> collect5 = person
                .stream()
                .filter(p -> p.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toCollection(TreeSet::new))));

        System.out.println(collect5);
    }
}
