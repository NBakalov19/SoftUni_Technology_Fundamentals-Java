package Demo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Judge {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    Map<String, Map<String, Integer>> contestsWithUserPoints = new LinkedHashMap<>();

    Map<String, Integer> userAndTotalPoints = new TreeMap<>();

    while (!input.equals("no more time")) {
      String[] tokens = input.split(" -> ");
      String username = tokens[0];
      String contest = tokens[1];
      int points = Integer.parseInt(tokens[2]);

      if (!contestsWithUserPoints.containsKey(contest)) {
        Map<String, Integer> userPoints = new TreeMap<>();
        userPoints.put(username, points);
        contestsWithUserPoints.put(contest, userPoints);

      } else {
        if (!contestsWithUserPoints.get(contest).containsKey(username) ||
                points > contestsWithUserPoints.get(contest).get(username)) {
          contestsWithUserPoints.get(contest).put(username, points);
        }

      }
      input = scanner.nextLine();
    }

    for (var entry : contestsWithUserPoints.entrySet()) {

      for (var value : entry.getValue().entrySet()) {

        if (!userAndTotalPoints.containsKey(value.getKey())) {

          userAndTotalPoints.put(value.getKey(), value.getValue());
        } else {

          userAndTotalPoints.put(value.getKey(), userAndTotalPoints.get(value.getKey()) + value.getValue());
        }
      }
    }

    int[] number = new int[1];
    contestsWithUserPoints.forEach((key, value) -> {
      number[0] = 0;
      System.out.println(
              String.format("%s: %d participants",
                      key, value.size()));
      value.entrySet().stream()
              .sorted((u1, u2) -> Integer.compare(u2.getValue(), u1.getValue()))
              .forEach(u -> System.out.println(

                      String.format("%d. %s <::> %d"
                              , ++number[0], u.getKey(), u.getValue())
              ));
    });

    number[0] = 0;

    System.out.println("Individual standings:");

    userAndTotalPoints.entrySet()
            .stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
            .forEach(user -> System.out.println(
                    String.format("%d. %s -> %d",
                            ++number[0], user.getKey(), user.getValue())));

  }
}