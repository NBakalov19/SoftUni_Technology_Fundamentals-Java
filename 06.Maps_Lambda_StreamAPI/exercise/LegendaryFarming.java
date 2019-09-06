package exercise;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean isObtained = false;

    HashMap<String, Integer> keyRegants = new HashMap<>();

    keyRegants.put("motes", 0);
    keyRegants.put("shards", 0);
    keyRegants.put("fragments", 0);

    TreeMap<String, Integer> junk = new TreeMap<>();

    while (!isObtained) {

      String[] materials = scanner.nextLine().split("\\s+");

      for (int i = 0; i < materials.length - 1; i += 2) {
        int quantity = Integer.parseInt(materials[i]);
        String regant = materials[i + 1].toLowerCase();

        if (regant.equals("motes") || regant.equals("shards")
                || regant.equals("fragments")) {

          keyRegants.put(regant, keyRegants.get(regant) + quantity);

          if (keyRegants.get(regant) >= 250) {
            keyRegants.put(regant, keyRegants.get(regant) - 250);

            switch (regant) {
              case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
              case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
              default:
                System.out.println("Valanyr obtained!");
                break;
            }
            isObtained = true;
            break;
          }
        } else {
          if (!junk.containsKey(regant)) {
            junk.put(regant, quantity);
          } else {
            junk.put(regant, junk.get(regant) + quantity);
          }
        }
      }
    }
    keyRegants.entrySet()
            .stream()
            .sorted((a, b) -> {
              if (b.getValue() - a.getValue() == 0) {
                return a.getKey().compareTo(b.getKey());
              } else {
                return b.getValue() - a.getValue();
              }
            })//Map.Entry.<String, Integer>comparingByValue()
            //.reversed()
            //.thenComparing(Map.Entry.comparingByKey()))
            .forEach(entry -> System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue())));

    junk.forEach((k, v) -> System.out.println(String.format("%s: %d", k, v)));
  }
}