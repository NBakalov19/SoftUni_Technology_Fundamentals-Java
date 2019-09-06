package exercise.orderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    ArrayList<Person> personArrayList = new ArrayList<>();

    while (!line.equals("End")) {
      String[] tokens = line.split("\\s+");
      String name = tokens[0];
      String id = tokens[1];
      int age = Integer.parseInt(tokens[2]);

      Person persons = new Person(name, id, age);

      personArrayList.add(persons);

      line = scanner.nextLine();
    }

    personArrayList.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .forEach(person -> System.out.println(person.toString()));
  }
}