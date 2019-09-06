package lab;

import java.util.Scanner;

public class CenturiesToMinutes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int centuries = Integer.parseInt(sc.nextLine());
    int years = centuries * 100;
    int days = (int) (years * 365.2422);
    int hours = days * 24;
    int minutes = hours * 60;

    System.out.println(String.format("%d centuries = %d years = %d days = %d hours = %d minutes",
            centuries,
            years,
            days,
            hours,
            minutes));
  }
}