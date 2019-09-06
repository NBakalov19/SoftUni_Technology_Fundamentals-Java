package lab;

import java.util.Scanner;

public class Elevator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int people = Integer.parseInt(sc.nextLine());
    int capacity = Integer.parseInt(sc.nextLine());

    int courses = (int) Math.ceil((double) people / capacity);

    System.out.println(courses);
  }
}