package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        numbers.add(3, 0);

        numbers.forEach(n -> System.out.println(n + " "));
    }
}
