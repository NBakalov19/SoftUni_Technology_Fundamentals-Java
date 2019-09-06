package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {

  private static List<Integer> rightRotation(List<Integer> numbers, int countOfRotations) {

    countOfRotations = countOfRotations % numbers.size();

    while (countOfRotations > 0) {
      numbers.add(0, numbers.get(numbers.size() - 1));
      numbers.remove(numbers.size() - 1);
      countOfRotations--;
    }

    return numbers;
  }

  private static List<Integer> leftRotation(List<Integer> numbers, int countOfRotations) {

    countOfRotations = countOfRotations % numbers.size();

    while (countOfRotations > 0) {
      numbers.add(numbers.get(0));
      numbers.remove(numbers.get(0));
      countOfRotations--;
    }
    return numbers;

  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    List<Integer> numbers =
            Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    String command = scanner.nextLine();

    while (!command.equals("End")) {
      String[] cmd = command.split(" ");

      switch (cmd[0]) {
        case "Add":
          int number = Integer.parseInt(cmd[1]);
          numbers.add(number);
          break;
        case "Insert":
          number = Integer.parseInt(cmd[1]);
          int index = Integer.parseInt(cmd[2]);
          if (index >= 0 && index <= numbers.size() - 1) {
            numbers.add(index, number);
          } else {
            System.out.println("Invalid index");
          }
          break;
        case "Remove":
          index = Integer.parseInt(cmd[1]);
          if (index >= 0 && index <= numbers.size() - 1) {
            numbers.remove(index);
          } else {
            System.out.println("Invalid index");
          }
          break;
        case "Shift":
          switch (cmd[1]) {
            case "left":
              int countOfRotations = Integer.parseInt(cmd[2]);
              numbers = leftRotation(numbers, countOfRotations);
              break;
            case "right":
              countOfRotations = Integer.parseInt(cmd[2]);
              numbers = rightRotation(numbers, countOfRotations);
              break;
          }
          break;
      }
      command = scanner.nextLine();
    }
    numbers.forEach(n -> System.out.print(n + " "));
  }
}