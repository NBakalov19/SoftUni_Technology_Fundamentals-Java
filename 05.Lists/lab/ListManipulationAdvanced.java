package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {

  private static void containElement(List<Integer> numbers, int numberToCheck) {
    if (numbers.contains(numberToCheck)) {
      System.out.println("Yes");
    } else {
      System.out.println("No such number");
    }
  }

  private static String getEvenElements(List<Integer> numbers) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i <= numbers.size() - 1; i++) {
      if (numbers.get(i) % 2 == 0) {
        output.append(numbers.get(i)).append(" ");
      }
    }
    return output.toString();
  }

  private static String getOddElements(List<Integer> numbers) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i <= numbers.size() - 1; i++) {
      if (numbers.get(i) % 2 == 1) {
        output.append(numbers.get(i)).append(" ");
      }
    }
    return output.toString();
  }

  private static void printSumOfListElements(List<Integer> numbers) {
    long sum = 0L;

    for (Integer number : numbers) {
      sum += number;
    }

    System.out.println(sum);
  }

  private static List<Integer> compareSmaller(List<Integer> numbers, int numberToFilter) {
    List<Integer> filtered = new ArrayList<>();

    for (int i = 0; i <= numbers.size() - 1; i++) {
      if (numbers.get(i) < numberToFilter) {
        filtered.add(numbers.get(i));
      }
    }

    return filtered;
  }

  private static List<Integer> compareSmallerOrEven(List<Integer> numbers, int numberToFilter) {
    List<Integer> filtered = new ArrayList<>();

    for (int i = 0; i <= numbers.size() - 1; i++) {
      if (numbers.get(i) <= numberToFilter) {
        filtered.add(numbers.get(i));
      }
    }

    return filtered;
  }

  private static List<Integer> compareGreater(List<Integer> numbers, int numberToFilter) {
    List<Integer> filtered = new ArrayList<>();

    for (int i = 0; i <= numbers.size() - 1; i++) {
      if (numbers.get(i) > numberToFilter) {
        filtered.add(numbers.get(i));
      }
    }
    return filtered;
  }

  private static List<Integer> compareGreaterOrEven(List<Integer> numbers, int numberToFilter) {
    List<Integer> filtered = new ArrayList<>();

    for (int i = 0; i <= numbers.size() - 1; i++) {
      if (numbers.get(i) >= numberToFilter) {
        filtered.add(numbers.get(i));
      }
    }
    return filtered;
  }

  private static void printList(List<Integer> numbers) {
    for (int numb : numbers) {
      System.out.print(numb + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Integer> numbers =
            Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    while (true) {

      String line = scanner.nextLine();

      if (line.equals("end")) {
        break;
      }

      String[] command = line.split(" ");

      switch (command[0]) {
        case "Contains":
          int numberToCheck = Integer.parseInt(command[1]);
          containElement(numbers, numberToCheck);
          break;
        case "Print":
          if (command[1].equals("even")) {
            System.out.println(getEvenElements(numbers).trim());
          } else {
            System.out.println(getOddElements(numbers).trim());
          }
          break;
        case "Get":
          if (command[1].equals("sum")) {
            printSumOfListElements(numbers);
          }
          break;
        case "Filter":
          switch (command[1]) {
            case "<":
              int numberToFilter = Integer.parseInt(command[2]);
              printList(compareSmaller(numbers, numberToFilter));
              break;
            case "<=":
              numberToFilter = Integer.parseInt(command[2]);
              printList(compareSmallerOrEven(numbers, numberToFilter));
              break;
            case ">":
              numberToFilter = Integer.parseInt(command[2]);
              printList(compareGreater(numbers, numberToFilter));
              break;
            case ">=":
              numberToFilter = Integer.parseInt(command[2]);
              printList(compareGreaterOrEven(numbers, numberToFilter));
              break;
          }
          break;
      }
    }
  }
}
