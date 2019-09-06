package exercise;

import java.util.Scanner;

public class ArrayRotation {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String[] strNumbers = scanner.nextLine().split(" ");

    int rotations = Integer.parseInt(scanner.nextLine());

    rotations = rotations % strNumbers.length;

    for (int i = 0; i < rotations; i++) {
      String element = strNumbers[0];
      System.arraycopy(strNumbers, 1, strNumbers, 0, strNumbers.length - 1);
      strNumbers[strNumbers.length - 1] = element;
    }
    for (String strNumber : strNumbers) {
      System.out.print(strNumber + " ");
    }
  }
}