package lab;

import java.util.Scanner;

public class SpecialNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int number = Integer.parseInt(sc.nextLine());

    for (int i = 1; i <= number; i++) {

      int sum = 0;
      int digit = i;

      while (digit > 0) {
        sum += digit % 10;
        digit /= 10;
      }
      if ((sum == 5) || (sum == 7) || (sum == 11)) {
        System.out.println(String.format("%d -> True", i));
      } else {
        System.out.println(String.format("%d -> False", i));
      }
    }
  }
}