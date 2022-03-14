package task1;

import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        var array = List.of(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        Stream<Integer> steamArray = array.stream();
        steamArray.filter(element -> element > 0)
                .filter(element -> element % 2 == 0)
                .sorted()
                .forEach(System.out::println);
    }
}
