package lab;

import java.util.Scanner;

public class PrintReverseOrder {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int size = Integer.parseInt(scanner.nextLine());

    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      int value = Integer.parseInt(scanner.nextLine());
      arr[i] = value;
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.print(String.format("%d ", arr[i]));
    }
  }
}