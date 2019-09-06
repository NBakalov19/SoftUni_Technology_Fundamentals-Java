package lab;

import java.util.Scanner;

public class TheatrePromotion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String dayOfWeek = sc.nextLine().toLowerCase();
    int age = Integer.parseInt(sc.nextLine());
    int money = 0;

    switch (dayOfWeek) {
      case "weekday":
        if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
          money = 12;
        } else if (age > 18 && age <= 64) {
          money = 18;
        }

        break;
      case "weekend":
        if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
          money = 15;
        } else if (age > 18 && age <= 64) {
          money = 20;
        }

        break;
      case "holiday":
        if (age >= 0 && age <= 18) {
          money = 5;
        } else if (age > 18 && age <= 64) {
          money = 12;
        } else if (age > 64 && age <= 122) {
          money = 10;
        }
        break;
    }
    if (money > 0) {
      System.out.printf("%s$", money);
    } else {
      System.out.println("Error!");
    }
  }
}
