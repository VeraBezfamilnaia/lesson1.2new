package task2;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorter {
    private static final int START_MILITARY_AGE = 18;
    private static final int END_MILITARY_AGE = 27;
    private static final int LOWER_WORKING_AGE = 18;
    private static final int UPPER_WORKING_AGE_FOR_WOMAN = 60;
    private static final int UPPER_WORKING_AGE_FOR_MAN = 65;

    public static long searchForMinorsCount(Supplier<Stream<Person>> getStreamForPersonBySupplier) {
        return getStreamForPersonBySupplier.get().
                filter(person -> person.getAge() < 18)
                .count();
    }

    public static List<String> getConscriptsFamilyList(Supplier<Stream<Person>> getStreamForPersonBySupplier) {
        return getStreamForPersonBySupplier.get()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= START_MILITARY_AGE)
                .filter(person -> person.getAge() <= END_MILITARY_AGE)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    public static List<String> getAbleBodiedPeopleFamilyWithHigherEducationList(Supplier<Stream<Person>> getStreamForPersonBySupplier) {
        return getStreamForPersonBySupplier.get()
                .filter(person -> {
                    var personAge = person.getAge();
                    var personSex = person.getSex();
                    return personAge >= LOWER_WORKING_AGE &&
                            (personSex.equals(Sex.MAN) && personAge <= UPPER_WORKING_AGE_FOR_MAN)
                            || personAge >= LOWER_WORKING_AGE &&
                            (personSex.equals(Sex.WOMAN) && personAge <= UPPER_WORKING_AGE_FOR_WOMAN);
                })
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .map(Person::getFamily)
                .sorted()
                .collect(Collectors.toList());
    }
}
