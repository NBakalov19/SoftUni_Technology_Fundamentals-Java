package exercise;

import java.util.*;

public class Courses {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Map<String, ArrayList<String>> courses = new LinkedHashMap<>();
    String line = scanner.nextLine();

    while (!line.equals("end")) {
      String[] commands = line.split(" : ");
      String module = commands[0];
      String studentName = commands[1];

      if (!courses.containsKey(module)) {
        courses.put(module, new ArrayList<>());
        courses.get(module).add(studentName);
      } else {
        courses.get(module).add(studentName);
      }

      line = scanner.nextLine();
    }

    courses.entrySet()
            .stream()
            .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
            .forEach((e1) -> {
              System.out.printf("%s: %d%n", e1.getKey(), e1.getValue().size());
              e1.getValue()
                      .stream()
                      .sorted((x1, x2) -> {
                        int first = x1.length();
                        int second = x2.length();
                        return x1.compareTo(x2);
                      }).forEach(x -> System.out.println("-- " + x));
            });
  }
}