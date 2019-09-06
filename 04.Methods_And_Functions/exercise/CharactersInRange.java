package exercise;

import java.util.Scanner;

public class CharactersInRange {

  private static void printAsciInRange(char begin, char end) {

    begin++;

    for (char symbol = begin; symbol < end; symbol++) {
      System.out.print(symbol + " ");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    char begin = scanner.nextLine().charAt(0);
    char end = scanner.nextLine().charAt(0);

    if (begin > end) {
      char temp = begin;
      begin = end;
      end = temp;
    }

    printAsciInRange(begin, end);
  }
}