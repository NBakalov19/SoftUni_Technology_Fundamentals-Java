package exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    LinkedHashMap<String, Integer> mining = new LinkedHashMap<>();
    int counter = 0;
    String minerals = "";

    while (!line.equals("stop")) {
      counter++;

      if (counter % 2 == 1) {
        if (!mining.containsKey(line)) {
          mining.put(line, 0);
        }
      } else {
        int quantity = Integer.parseInt(line);
        mining.put(minerals, mining.get(minerals) + quantity);
      }
      minerals = line;
      line = scanner.nextLine();
    }

    mining.forEach((k, v) -> System.out.println(String.format("%s -> %d", k, v)));
  }
}