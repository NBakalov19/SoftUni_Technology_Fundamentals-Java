package lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int[] firstArr = Arrays
            .stream(scanner.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    int[] secondArr = Arrays
            .stream(scanner.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    int sum = 0;

    int maxLenght = Math.max(firstArr.length, secondArr.length);
    boolean isFinish = false;
    for (int i = 0; i < maxLenght; i++) {

      if (firstArr[i] != secondArr[i]) {
        System.out.printf("Arrays are not identical. Found difference at %d index.", i);
        break;

      } else {
        sum += firstArr[i];
        if (i == maxLenght - 1) {
          isFinish = true;
        }
      }
    }

    if (isFinish == true) {
      System.out.printf("Arrays are identical. Sum: %d", sum);
    }
  }
}
