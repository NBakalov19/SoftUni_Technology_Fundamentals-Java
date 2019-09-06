package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class OpinionPoll {

  static class Person {
    String name;
    int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfPersons = Integer.parseInt(scanner.nextLine());

    ArrayList<Person> persons = new ArrayList<>();

    for (int i = 0; i < countOfPersons; i++) {
      String[] line = scanner.nextLine().split("\\s+");

      String name = line[0];
      int age = Integer.parseInt(line[1]);

      Person person = new Person(name, age);

      persons.add(person);
    }

    persons.stream()
            .filter((p -> p.age > 30))
            .sorted(Comparator.comparing(o -> o.name))
            .forEach(person -> System.out.println(String.format("%s - %d", person.name, person.age)));
  }
}