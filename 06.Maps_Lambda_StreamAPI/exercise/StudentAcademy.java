package exercise;

import java.util.*;

public class StudentAcademy {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());

    Map<String, ArrayList<Double>> studentsGrade = new LinkedHashMap<>();

    while (n > 0) {
      String name = scanner.nextLine();
      double grade = Double.parseDouble(scanner.nextLine());

      if (!studentsGrade.containsKey(name)) {
        studentsGrade.put(name, new ArrayList<>());
        studentsGrade.get(name).add(grade);
      } else {
        studentsGrade.get(name).add(grade);
      }
      n--;
    }

    Map<String, Double> averageStudentsGrades = new LinkedHashMap<>();

    for (String name : studentsGrade.keySet()) {
      double sum = 0d;

      for (int i = 0; i < studentsGrade.get(name).size(); i++) {
        sum += studentsGrade.get(name).get(i);
      }

      double average = sum / studentsGrade.get(name).size();

      if (average >= 4.5) {
        averageStudentsGrades.put(name, average);
      }
    }

    averageStudentsGrades.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry ->
                    System.out.println(
                            String.format("%s -> %.2f", entry.getKey(), entry.getValue())));
  }
}
