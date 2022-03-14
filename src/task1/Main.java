package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var array = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        var filteredArray = getFilteredArray(array);
        Collections.sort(filteredArray);
        System.out.println(filteredArray);
    }

    private static List<Integer> getFilteredArray(List<Integer> array) {
        List<Integer> filteredArray = new ArrayList<>();
        for (Integer integer : array) {
            if (integer > 0 && integer % 2 == 0) {
                filteredArray.add(integer);
            }
        }
        return filteredArray;
    }
}
