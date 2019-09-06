package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Integer> numbers =
            Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    List<Integer> commands =
            Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    int bombNumber = commands.get(0);
    int power = commands.get(1);

    while (numbers.contains(bombNumber)) {
      int index = numbers.indexOf(bombNumber);
      int begin = index - power;

      begin = Math.max(0, begin);

      if (index > begin) {
        numbers.subList(begin, index).clear();
      }

      index = numbers.indexOf(bombNumber);

      int end = Math.min(index + power, numbers.size() - 1);

      if (end >= index) {
        numbers.subList(index, end + 1).clear();
      }
    }
    int sum = 0;
    for (int i = 0; i <= numbers.size() - 1; i++) {
      sum += numbers.get(i);
    }
    System.out.println(sum);
  }
}