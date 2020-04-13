import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorExample {
    public static void main(String[] args) throws IOException {

        List<Person> person = new ArrayList<>();

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(ComparatorExample.class.getResourceAsStream("people.txt")));
                Stream<String> stream = reader.lines();
        ){
            readPersonFile(person, stream);
        }

        Comparator<Person> cmp = Comparator
                                        .comparing(Person::getName)
                                        .thenComparing(Person::getAge);

        person.sort(cmp);
        System.out.println("---------------SORTED on name and then on AGE   ------------------");
        person.forEach(System.out::println);

        Comparator<Person> cmp2 = Comparator
                .comparing(Person::getName)
                .thenComparing(Person::getAge)
                .reversed();

        person.sort(cmp2);
        System.out.println("---------------Reverse SORTED on name and then on AGE------------------");
        person.forEach(System.out::println);



    }

    public static void readPersonFile(List<Person> person, Stream<String> stream) {
        stream.map(
                line -> {
                    String[] s = line.split(" ");
                    Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                    person.add(p);
                    return p;
                })
                .forEach(System.out::println)   ;
    }
}
