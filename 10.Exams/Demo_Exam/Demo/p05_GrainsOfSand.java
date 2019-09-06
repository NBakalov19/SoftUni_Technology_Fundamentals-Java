package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_GrainsOfSand {

  private static int getGreaterOrEqualNumber(List<Integer> numbers, int value) {
    int greaterNumber = Integer.MIN_VALUE;

    for (Integer number : numbers) {
      if (greaterNumber < number && number >= value) {
        greaterNumber = number;
        break;
      }
    }
    return greaterNumber;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    String line = scanner.nextLine();

    while (!line.equals("Mort")) {
      String[] cmd = line.split(" ");
      String command = cmd[0];
      int value = Integer.parseInt(cmd[1]);

      switch (command) {
        case "Add":
          numbers.add(value);
          break;
        case "Remove":
          if (numbers.contains(value)) {
            numbers.remove(Integer.valueOf(value));
          } else if (value >= numbers.get(0) && value <= numbers.size() - 1) {
            numbers.remove(value);
          }
          break;
        case "Replace":
          int replacement = Integer.parseInt(cmd[2]);
          if (numbers.contains(value)) {
            int index = numbers.indexOf(value);
            numbers.set(index, replacement);
          }
          break;
        case "Increase":
          int greaterNumber = getGreaterOrEqualNumber(numbers, value);

          if (greaterNumber != Integer.MIN_VALUE) {
            for (int i = 0; i < numbers.size(); i++) {
              numbers.set(i, numbers.get(i) + greaterNumber);
            }
          } else {
            for (int i = 0; i < numbers.size(); i++) {
              numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            }
          }
          break;
        default:
          numbers.removeIf(n -> n < value);
          break;
      }

      line = scanner.nextLine();
    }
    for (Integer number : numbers) {
      System.out.print(number + " ");
    }
  }
}