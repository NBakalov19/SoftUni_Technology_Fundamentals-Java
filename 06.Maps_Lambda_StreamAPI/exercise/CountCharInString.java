package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharInString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String text = scanner.nextLine();

    char[] textArr = text.toCharArray();

    LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();

    for (char symbol : textArr) {

      if (symbol != ' ') {
        counts.putIfAbsent(symbol, 0);
        counts.put(symbol, counts.get(symbol) + 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
      System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
    }
  }
}