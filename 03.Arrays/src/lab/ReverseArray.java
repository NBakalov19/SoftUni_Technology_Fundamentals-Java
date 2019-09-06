package lab;

import java.util.Scanner;

public class ReverseArray {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String[] text = scanner.nextLine().split(" ");

    for (int i = 0; i < text.length / 2; i++) {
      String oldText = text[i];
      text[i] = text[text.length - 1 - i];
      text[text.length - 1 - i] = oldText;
    }
    System.out.println(String.join(" ", text));
  }
}