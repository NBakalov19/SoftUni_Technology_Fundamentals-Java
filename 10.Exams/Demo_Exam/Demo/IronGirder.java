package Demo;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class IronGirder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    Map<String, Integer> townWithTime = new TreeMap<>();
    Map<String, Integer> townWithPassengers = new TreeMap<>();


    while (!input.equals("Slide rule")) {
      String[] tokens = input.split(":");
      String town = tokens[0];
      String[] timeAndPassengers = tokens[1].split("->");
      String command = timeAndPassengers[0];
      int passengers = Integer.parseInt(timeAndPassengers[1]);

      if (!command.equals("ambush")) {
        int time = Integer.parseInt(timeAndPassengers[0]);
        townWithTime.putIfAbsent(town, time);
        townWithPassengers.putIfAbsent(town, 0);
        if (townWithTime.get(town) > time || townWithTime.get(town) == 0) {
          townWithTime.put(town, time);
        }
        townWithPassengers.put(town, townWithPassengers.get(town) + passengers);
      } else {
        if (townWithTime.containsKey(town)) {
          townWithTime.put(town, 0);
        }
        if (townWithPassengers.containsKey(town)) {
          townWithPassengers.put(town, townWithPassengers.get(town) - passengers);
        }
      }

      input = scanner.nextLine();
    }

    townWithTime.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getValue))
            .forEach(town -> {
              if (town.getValue() > 0 && townWithPassengers.get(town.getKey()) > 0) {
                System.out.println(String.format("%s -> Time: %d -> Passengers: %d",
                        town.getKey(), town.getValue(), townWithPassengers.get(town.getKey())));
              }
            });

  }
}