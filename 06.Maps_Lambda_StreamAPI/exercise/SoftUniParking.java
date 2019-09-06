package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, String> parking = new LinkedHashMap<>();
    int count = Integer.parseInt(scanner.nextLine());

    while (count > 0) {

      String[] cmd = scanner.nextLine().split(" ");
      String command = cmd[0];
      String username = cmd[1];

      switch (command) {
        case "register":
          if (!parking.containsKey(username)) {
            String plateNumber = cmd[2];
            parking.put(username, "");
            parking.put(username, plateNumber);
            System.out.println(String.format("%s registered %s successfully", username, plateNumber));
          } else {
            String plateNumber = cmd[2];
            System.out.println(String.format("ERROR: already registered with plate number %s", plateNumber));
          }
          break;
        case "unregister":
          if (parking.containsKey(username)) {
            parking.remove(username);
            System.out.println(String.format("%s unregistered successfully", username));
          } else {
            System.out.println(String.format("ERROR: user %s not found", username));
          }
          break;
      }
      count--;
    }

    parking.forEach((k, v) -> System.out.println(String.format("%s => %s", k, v)));
  }
}