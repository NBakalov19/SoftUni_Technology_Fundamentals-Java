package Demo;

import java.text.DecimalFormat;
import java.util.Scanner;

public class p07_HornetWing {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int wingFlapsToDO = Integer.parseInt(scanner.nextLine());
    double distancePer1kFlaps = Double.parseDouble(scanner.nextLine());
    int endurance = Integer.parseInt(scanner.nextLine());

    double distance = (wingFlapsToDO / 1000.0) * distancePer1kFlaps;

    int timeWithoutRest = wingFlapsToDO / 100;

    long timeForRest = (wingFlapsToDO / endurance) * 5;

    long totalTime = timeForRest + timeWithoutRest;

    System.out.println(String.format("%.2f m.", distance));
    System.out.println(String.format("%d s.", totalTime));
  }
}