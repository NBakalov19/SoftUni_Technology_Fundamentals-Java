package lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArray {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int[] numbers = Arrays
            .stream(scanner.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    int[] condensedArr = new int[numbers.length - 1];

    if (numbers.length == 1) {
      System.out.println(numbers[0]);
      return;
    }

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < condensedArr.length - i; j++) {
        condensedArr[j] = numbers[j] + numbers[j + 1];

      }
      numbers = condensedArr;
    }
    System.out.println(condensedArr[0]);
  }
}
