package exercise.students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfStudents = Integer.parseInt(scanner.nextLine());

    ArrayList<Student> studentsArrayList = new ArrayList<>();

    for (int i = 0; i < countOfStudents; i++) {
      String[] line = scanner.nextLine().split("\\s+");

      String firstName = line[0];
      String lastName = line[1];
      double grade = Double.parseDouble(line[2]);

      Student student = new Student(firstName, lastName, grade);

      studentsArrayList.add(student);
    }

    studentsArrayList.stream()
            .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
            .forEach(student -> System.out.println(student.toString()));
  }
}
