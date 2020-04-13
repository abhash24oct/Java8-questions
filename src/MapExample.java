import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        MapExample.class.getResourceAsStream("PeopleWithSex.txt")));

                Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(
                        s[0].trim(),
                        Integer.parseInt(s[1]),
                        s[2].trim()
                );
                persons.add(p);
                return p;
            })
                    .forEach(System.out::println);


        } catch (IOException ioe) {
            System.out.println(ioe);
        }

     //   persons.forEach(System.out::println);

        List<Person> p1 = persons.subList(1,10);
        List<Person> p2 = persons.subList(10,persons.size());

        System.out.println("First List");
        Map<Integer,List<Person>> map1 = mapByAge(p1);
        map1.forEach((k,v)-> System.out.println(k+" -> "+v));

        System.out.println("Second List");
        Map<Integer,List<Person>> map2 = mapByAge(p1);
        map2.forEach((k,v)-> System.out.println(k+" -> "+v));

        System.out.println("-------------Merged maps ----------------------");
        map2.entrySet().stream()
                    .forEach(
                            entrySet -> {
                                map1.merge(
                                        entrySet.getKey()
                                        ,entrySet.getValue()
                                        ,(l1,l2) -> {
                                            l1.addAll(l2);
                                            return l1;
                                        }
                                );
                            }
                    );

        map1.forEach((k,v)-> System.out.println(k+" -> "+v));
    }

    private static Map<Integer,List<Person>> mapByAge(List<Person> person){
        Map<Integer,List<Person>> map = person
                                                .stream()
                                                .collect(Collectors.groupingBy(Person::getAge));
        return map;

    }
}
