package Demo;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, List<String>> dictionary = new TreeMap<>();

    String[] input = scanner.nextLine().split(" \\| ");
    List<String> wordsToCheck = Arrays.stream(scanner.nextLine().split(" \\| "))
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());

    String command = scanner.nextLine();

    for (String s : input) {
      String[] wordWithDescription = s.split(": ");
      String word = wordWithDescription[0];
      String description = wordWithDescription[1];
      dictionary.putIfAbsent(word, new ArrayList<>());
      dictionary.get(word).add(description);
    }

    if (command.equals("End")) {
      for (String word : wordsToCheck) {
        if (dictionary.containsKey(word)) {
          System.out.println(String.format("%s", word));
          dictionary.get(word).sort(Comparator.comparingInt(String::length).reversed());
          dictionary.get(word).forEach(d -> System.out.printf(" -%s%n", d));
        }
      }
    } else {
      System.out.println(String.join(" ", dictionary.keySet()));
    }
  }
}