package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var persons = getPersonsList();
        Supplier<Stream<Person>> getStreamForPersonBySupplier = persons::stream;

        System.out.println(Sorter.searchForMinorsCount(getStreamForPersonBySupplier));
        System.out.println(Sorter.getConscriptsFamilyList(getStreamForPersonBySupplier));
        System.out.println(Sorter.getAbleBodiedPeopleFamilyWithHigherEducationList(getStreamForPersonBySupplier));
    }

    private static Collection<Person> getPersonsList() {
        var names = Arrays.asList("Jack", "Connor", "Young", "George", "Samuel", "John");
        var families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}
