package lab;

import java.util.*;

public class WordSynonyms {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = Integer.parseInt(scanner.nextLine());
    Map<String, ArrayList<String>> words = new LinkedHashMap<String, ArrayList<String>>();

    for (int i = 0; i < n; i++) {

      String word = scanner.nextLine();
      String synonym = scanner.nextLine();

      words.putIfAbsent(word, new ArrayList<>());
      words.get(word).add(synonym);
    }

    for (HashMap.Entry<String, ArrayList<String>> pair : words.entrySet()) {
      System.out.print(pair.getKey() + " - ");
      System.out.println(String.join(", ", pair.getValue()));
    }
  }
}