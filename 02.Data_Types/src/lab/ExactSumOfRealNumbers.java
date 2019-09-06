package lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int count = Integer.parseInt(sc.nextLine());
    BigDecimal sum = new BigDecimal(0);

    for (int i = 0; i < count; i++) {
      BigDecimal number = new BigDecimal(sc.nextLine());
      sum = sum.add(number);
    }
    System.out.println(sum);
  }
}